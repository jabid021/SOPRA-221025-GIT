package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import context.Singleton;
import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;


public class App {

	static Compte connected;
	static boolean isPause = false;
	
	static IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	static IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
	static IDAOVisite daoVisite = Singleton.getInstance().getDaoVisite();
	
	

	public static String saisieString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		String saisie = sc.nextLine();
		return saisie;
	}

	public static double saisieDouble(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		double saisie = sc.nextDouble();
		return saisie;
	}

	public static int saisieInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int saisie = sc.nextInt();
		return saisie;
	}

	public static boolean saisieBoolean(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextBoolean();
	}

	public static void menuPrincipal() {
		System.out.println("Application HOPITAL");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Fermer ");
		int choix = saisieInt("Choisir un menu");

		switch (choix) {
		case 1 -> seConnecter();
		case 2 -> System.exit(0);
		}
		menuPrincipal();

	}

	public static void seConnecter() {
		String login = saisieString("Saisir login");
		String password = saisieString("Saisir password");
		connected = daoCompte.seConnecter(login, password);

		if (connected instanceof Secretaire) {
			if (isPause) {
				menuPause();
			}
			else{
				menuSecretaire();
			}

		}

		else if (connected instanceof Medecin) {
			int salle = saisieInt("Choisir une salle ");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}

		else {
			System.out.println("Identifiants invalides");
		}

	}

	public static void menuSecretaire() {
		System.out.println("Menu Secretaire : ");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Les visites d'un patient");
		System.out.println("3 - L'état de la file d'attente");
		System.out.println("4 - Partir en pause");
		System.out.println("5 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch (choix) {
		case 1:
			recevoirPatient();
			break;
		case 2:
			visitesPatient();
			break;
		case 3:
			fileAttente();
			break;
		case 4:
			isPause = true;
			pause();
			break;
		case 5:
			connected = null;
			menuPrincipal();
			break;

		}

		menuSecretaire();
	}
	
	public static void menuPause() 
	{
		System.out.println("Menu Secretaire - PAUSE : ");
		System.out.println("1 - Retour de pause");
		System.out.println("2 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch (choix) {
		case 1:
			isPause = false;
			chargerFileAttente();
			menuSecretaire();
		case 2:
			menuPrincipal();
		}
	}
	
	
	public static void menuMedecin() {

		System.out.println("Menu Medecin : ");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - L'état de la file d'attente");
		System.out.println("3 - Sauvegarder la visite");
		System.out.println("4 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch (choix) {
		case 1:
			recevoirPatient();
			break;
		case 2:
			fileAttente();
			Patient p = Singleton.getInstance().getFileAttente().peek();
			System.out.println("Le prochain patient est : " + p);
			break;
		case 3:
			sauvegarderVisite();
			break;
		case 4:
			connected = null;
			menuPrincipal();
			break;

		}

		menuMedecin();
	}

	public static void recevoirPatient() {

		if (connected instanceof Secretaire) {

			int idPatient = saisieInt("Saisir l'id du patient");
			Patient p = daoPatient.findById(idPatient);
			if (p == null) {
				String prenom = saisieString("Saisir votre prenom");
				String nom = saisieString("Saisir votre nom");

				p = new Patient(idPatient, nom, prenom);
				daoPatient.insert(p);
			}
			Singleton.getInstance().getFileAttente().add(p);

		} else {
			Medecin medecin= (Medecin) connected;
			
			// Retirer le premier patient de la file, lui creer une visite
			if (!Singleton.getInstance().getFileAttente().isEmpty()) {
				Patient p = Singleton.getInstance().getFileAttente().poll();
				Visite visite = new Visite(p, medecin);
				medecin.getVisites().add(visite);
			}
			if (medecin.getVisites().size() == 10) {
				sauvegarderVisite();
			}
		}

	}

	public static void visitesPatient() {
		Integer id = saisieInt("Saisir l'id du patient");
		List<Visite> consultations = daoVisite.findAllByIdPatient(id);
		if (consultations != null) {
			for (Visite v : consultations) {
				System.out.println(v);
			}
		} else {
			System.out.println("Pas de consultation pour ce patient!");
		}

	}

	public static void fileAttente() {

		for (Patient p : Singleton.getInstance().getFileAttente()) {
			System.out.println(p);
		}

	}

	public static void pause() {

		sauvegarderFileAttente();
		System.out.println("Menu Secretaire - PAUSE : ");
		System.out.println("1 - Retour de pause");
		System.out.println("2 - Retour au menu principal");
		int choix = saisieInt("Choisir un menu");

		switch (choix) {
		case 1:
			chargerFileAttente();
			menuSecretaire();
			isPause=false;
			break;
		case 2:
			connected = null;
			menuPrincipal();
			break;
		}

	}

	public static void sauvegarderFileAttente() {

		File monFichier = new File("fileAttente.txt");

		try (FileOutputStream fos = new FileOutputStream(monFichier);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(Singleton.getInstance().getFileAttente());

		} catch (Exception e) {
			e.printStackTrace();
		}

		Singleton.getInstance().getFileAttente().clear();
	}

	public static void chargerFileAttente() {
		File monFichier = new File("fileAttente.txt");

		try (FileInputStream fis = new FileInputStream(monFichier);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			Singleton.getInstance().setFileAttente((LinkedList<Patient>) ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sauvegarderVisite() {

		for (Visite v : ((Medecin) connected).getVisites()) {
			daoVisite.insert(v);
		}
		((Medecin) connected).getVisites().clear();

	}

	public static void main(String[] args) {
		menuPrincipal();
	}

}
