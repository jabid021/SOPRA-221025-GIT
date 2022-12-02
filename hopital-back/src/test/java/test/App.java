package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompte;
import dao.DAOPatient;
import dao.DAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;

public class App {

	static LinkedList<Patient> fileAttente = new LinkedList();
	static Compte connected;
	static DAOCompte daoCompte = new DAOCompte();
	static DAOPatient daoPatient = new DAOPatient();
	static DAOVisite daoVisite = new DAOVisite();
	static boolean isPause = false;

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
			Patient p = fileAttente.peek();
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
				p = daoPatient.insert(p);
			}
			fileAttente.add(p);

		} else {
			Medecin medecin= (Medecin) connected;
			
			// Retirer le premier patient de la file, lui creer une visite
			if (!fileAttente.isEmpty()) {
				Patient p = fileAttente.poll();
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

		for (Patient p : fileAttente) {
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
			oos.writeObject(fileAttente);

		} catch (Exception e) {
			e.printStackTrace();
		}

		fileAttente.clear();
	}

	public static LinkedList<Patient> chargerFileAttente() {
		File monFichier = new File("fileAttente.txt");

		try (FileInputStream fis = new FileInputStream(monFichier);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			fileAttente = (LinkedList<Patient>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileAttente;

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
