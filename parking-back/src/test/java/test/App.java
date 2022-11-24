package test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompte;
import dao.DAOParking;
import dao.DAOPlace;
import dao.DAOReservation;
import dao.DAOVehicule;
import model.Admin;
import model.Adresse;
import model.Civilite;
import model.Compte;
import model.Moto;
import model.Parking;
import model.Place;
import model.Reservation;
import model.Responsable;
import model.Taille;
import model.Utilisateur;
import model.Vehicule;
import model.Voiture;

public class App {

	static Compte connected=null;
	
	
	static DAOCompte daoCompte = new DAOCompte();
	static DAOVehicule daoVehicule = new DAOVehicule();
	static DAOPlace daoPlace = new DAOPlace();
	static DAOParking daoParking = new DAOParking();
	static DAOReservation daoReservation = new DAOReservation();
	
	

	//---------------Menus---------------------//

	public static String saisieString(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();	
	}

	public static int saisieInt(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static boolean saisieBoolean(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextBoolean();
	}



	public static void menuPrincipal() {
		System.out.println("Appli PARKME");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - STOP");

		int choix=saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);break;
		}

		menuPrincipal();

	}



	public static void inscription() {
		System.out.println("Menu inscription");

		Compte compte = null;
		String choixCompte=saisieString("Choisir type de compte : Admin/Responsable / Utilisateur");
		String login= saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");


		if(choixCompte.equals("Admin")) 
		{
			compte = new Admin(login,password,nom,prenom);
		}
		else if(choixCompte.equals("Responsable")) 
		{
			String entreprise = saisieString("Saisir votre entreprise");
			compte = new Responsable(login, password, nom, prenom, entreprise);
		}
		else if(choixCompte.equals("Utilisateur")) 
		{
			String naissance = saisieString("Saisir votre date de naissance");
			String mail = saisieString("Saisir votre mail");
			String tel = saisieString("Saisir votre tel");
			String civ = saisieString("Choisir une civilite : "+Arrays.toString(Civilite.values()));

			compte = new Utilisateur(login, password, nom, prenom, false, LocalDate.parse(naissance), mail, tel, Civilite.valueOf(civ));
		}

		daoCompte.insert(compte);


	}


	public static void connexion() {

		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		connected = daoCompte.seConnecter(login, password);

		if(connected instanceof Admin) 
		{
			menuAdmin();
		}
		else if(connected instanceof Responsable) 
		{
			menuResponsable();
		}
		else if(connected instanceof Utilisateur) 
		{
			menuUtilisateur();
		}
		else 
		{
			System.out.println("Identifiants INVALIDES");
		}

	}






	public static void menuUtilisateur() {
		System.out.println("Menu User : "+connected.getLogin());
		System.out.println("1 - Faire une reservation");
		System.out.println("2 - Afficher mes reservations");
		System.out.println("3 - Afficher mes vehicules");
		System.out.println("4 - Ajouter un vehicule");
		System.out.println("5 - Modifier un vehicule");
		System.out.println("6 - Se deconnecter");


		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : reserver(); break;
		case 2 : afficherMesReservations();break;
		case 3 : afficherVehicules(); break;
		case 4 : ajouterVehicule(); break;
		case 5 : modifierVehicule(); break;
		case 6 : menuPrincipal();break;
		}

		menuUtilisateur();
	}

	public static void afficherMesReservations() {

		afficherVehicules();
		int idVehicule= saisieInt("Saisir l'id du vehicule");


		for(Reservation r : daoReservation.findAllByVehicule(idVehicule)) 
		{
			System.out.println(r);
		}

	}

	public static void reserver() {


		for(Parking p : daoParking.findAll()) 
		{
			System.out.println(p);
		}
		int idParking = saisieInt("Saisir l'id du parking");


		for(Place p : daoPlace.findAllByParking(idParking)) 
		{
			System.out.println(p);
		}

		int idPlace = saisieInt("Saisir l'id de la place");
		Place place = daoPlace.findById(idPlace);

		for(Vehicule v : daoVehicule.findAllByUtilisateur(connected.getId())) 
		{
			System.out.println(v);
		}
		int idVehicule = saisieInt("Saisir l'id de votre vehicule");

		Vehicule vehicule = daoVehicule.findById(idVehicule);
		String date = saisieString("Saisir la date de reservation");


		Reservation  resa = new Reservation(LocalDate.parse(date), false, place, vehicule);
		daoReservation.insert(resa);
	}




	public static void modifierVehicule() {
		afficherVehicules();
		//saisir l'id du vehicule
		int idVehicule= saisieInt("Saisir l'id du vehicule");
		Vehicule vehicule = daoVehicule.findById(idVehicule);
		//Faire saisir les infos du vehicule
		String marque = saisieString("Saisir la marque");
		String plaque = saisieString("Saisir la plaque") ;
		String typevehicule = saisieString("Choisir le type de véhicule: voiture ou moto");

		// Constructeur : public Vehicule(String marque, String plaque, Taille taille, Utilisateur utilisateur) {
		if(typevehicule.equals("voiture")){
			Taille taille = Taille.valueOf(saisieString("Saisir la taille")) ;
			Boolean decapotable = saisieBoolean("Decapotable? true/false");
			int nbPlace = saisieInt("Nombre de Places?");
			vehicule = new Voiture(idVehicule,  marque, plaque, taille, (Utilisateur)connected, nbPlace, decapotable);
		}
		else if(typevehicule.equals("moto")){
			int nbroues = saisieInt("Nombre de roues");

			vehicule = new Moto(idVehicule,marque, plaque, (Utilisateur)connected, nbroues);
		}
		daoVehicule.update(vehicule);

	}


	public static void ajouterVehicule() {
		///Faire saisir les infos du vehicule
		Vehicule vehicule = null;

		String marque = saisieString("Saisir la marque");
		String plaque = saisieString("Saisir la plaque") ;
		String typevehicule = saisieString("Choisir le type de véhicule: voiture ou moto");

		// Constructeur : public Vehicule(String marque, String plaque, Taille taille, Utilisateur utilisateur) {
		if(typevehicule.equals("voiture")){
			Taille taille = Taille.valueOf(saisieString("Saisir la taille")) ;
			Boolean decapotable = saisieBoolean("Decapotable? true/false");
			int nbPlace = saisieInt("Nombre de Places?");
			vehicule = new Voiture(marque, plaque, taille, (Utilisateur)connected, nbPlace, decapotable);
		}
		else if(typevehicule.equals("moto")){
			int nbroues = saisieInt("Nombre de roues");

			vehicule = new Moto(marque, plaque, (Utilisateur)connected, nbroues);
		}
		daoVehicule.insert(vehicule);
	}


	public static void afficherVehicules() {

		for(Vehicule v : daoVehicule.findAllByUtilisateur(connected.getId())) 
		{
			System.out.println(v);
		}

	}





	public static void menuResponsable() {
		System.out.println("Menu Responsable : "+connected.getLogin());

		System.out.println("1 - Creer un parking");
		System.out.println("2 - Modifier parking");
		System.out.println("3 - Afficher mes parking");
		System.out.println("4 - Ajouter une place à un de mes parking");
		System.out.println("5 - Modifier une place d'un parking");
		System.out.println("6 - Se deconnecter");


		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : ajouterParking(); break;
		case 2 : modifierParking();break;
		case 3 : afficherMesParking();break;
		case 4 : ajouterPlace();break;
		case 5 : modifierPlace();break;
		case 6 : menuPrincipal();
		}

		menuResponsable();




	}



	public static void modifierPlace() {
		afficherMesParking();
		int idpa =saisieInt("entrez l'id du parking");
		Parking par = daoParking.findById(idpa);
		for(Place p : daoPlace.findAllByParking(idpa)) 
		{
			System.out.println(p);
		}
		//Faire saisir l'id de la place 
		int idpl = saisieInt("entrez l'id de la place à modifier ");
		Place place = daoPlace.findById(idpl);
		//Faire saisir toutes les informations d'une place
		int nemp = saisieInt("entrez le nouvelle emplacement de la place");
		String ntail = saisieString("quel est la taille de la place ? (Petit/Moyen/Grand) ");
		Taille  taillep = Taille.valueOf(ntail); 

		place.setEmplacement(nemp);
		place.setTaille(taillep);
		daoPlace.update(place);

		//updatePlace(place);

	}
	public static void ajouterPlace() {
		afficherMesParking();
		int choixParking = saisieInt("choix ID parking");
		Parking parking =daoParking.findById(choixParking);

		//Faire saisir toutes les informations d'une place
		Integer emp = saisieInt("entrer emplacement");
		Taille taille = Taille.valueOf(saisieString("enter taille "+Arrays.toString(Taille.values())));

	
		//insertPlace(place);
		Place place = new Place(parking, taille, emp);
		daoPlace.insert(place);

	}
	public static void afficherMesParking() {
		List<Parking> mesParking = daoParking.findAllByResponsable(connected.getId());

		if(mesParking.isEmpty()) 
		{
			System.out.println("Vous n'avez pas de parking");
		}
		else 
		{
			for(Parking p : mesParking) 
			{
				System.out.println(p);
			}
		}

	}
	public static void modifierParking() {

		afficherMesParking();

		int id = saisieInt("Quel parking modifier (saisir son id");

		Parking p = daoParking.findById(id);

		double prix=saisieDouble ("saisir le prix du parking");
		Boolean handicap = saisieBoolean("parkign pour handicap ? false/true");
		String description = saisieString("Ajouter une description de votre parking");
		String numero = saisieString("Saisir le numero");
		String ville=saisieString("saisir la ville de parking");
		String voie=saisieString("saisir la voie de parking");
		String cp=saisieString("saisir le code postale de parking");

		Adresse adresse = new Adresse(numero,voie,ville,cp);

		p.setPrix(prix);
		p.setHandicap(handicap);
		p.setDescription(description);
		p.setAdresse(adresse);

		daoParking.update(p);

	}

	public static void ajouterParking() {



		String numero = saisieString("Saisir le numero");
		String ville=saisieString("saisir la ville de parking");
		String voie=saisieString("saisir la voie de parking");
		String cp=saisieString("saisir le code postale de parking");
		String description=saisieString("saisir une bref description  de parking");
		boolean handicap=saisieBoolean("saisir si votre parking est equipe de place pour les  handicape true sinon false  ");


		int etage =saisieInt("saisir le nombre d'etage passede votre parking");
		double  prix =saisieDouble("saisir le prix de votre  parking");

		//Faire saisir toutes les infos du parking :  prix,etage,handicap,description,numero,voie,ville,cp
		Adresse adresse = new Adresse(numero,voie,ville,cp);
		Parking p = new Parking(prix,etage, handicap,description,(Responsable) connected,adresse);
		daoParking.insert(p);
	}




	public static void menuAdmin() {
		System.out.println("Menu Admin "+connected.getLogin());

		System.out.println("1 - Afficher tous les comptes");
		System.out.println("2 - Modifier un compte");
		System.out.println("3 - Afficher tous les parking");
		System.out.println("4 - Se deconnecter");


		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : afficherComptes(); break;
		case 2 : modifierCompte();break;
		case 3 : afficherParkings();break;
		case 4 : menuPrincipal();
		}

		menuAdmin();



	}


	public static void afficherParkings() {
		for(Parking p : daoParking.findAll()) 
		{
			System.out.println(p);
		}

	}
	public static void modifierCompte() {
		afficherComptes();

		//Faire saisir l'id du compte
		Integer id= saisieInt("Saisir l'id du compte");
		Compte c = daoCompte.findById(id);

		c.setLogin(saisieString("Login"));
		c.setPassword(saisieString("Password"));
		c.setNom(saisieString("Nom"));
		c.setPrenom(saisieString("Prenom"));
		if(c instanceof Admin) 
		{
			
		}
		else if(c instanceof Responsable) 
		{
			String entreprise = saisieString("Saisir votre entreprise");
			((Responsable) c).setEntreprise(entreprise);
		}
		else if(c instanceof Utilisateur) 
		{
			String naissance = saisieString("Saisir votre date de naissance");
			String mail = saisieString("Saisir votre mail");
			String tel = saisieString("Saisir votre tel");
			String civ = saisieString("Choisir une civilite : "+Arrays.toString(Civilite.values()));

			((Utilisateur) c).setNaissance(LocalDate.parse(naissance));
			((Utilisateur) c).setMail(mail);
			((Utilisateur) c).setTelephone(tel);
			((Utilisateur) c).setCivilite(Civilite.valueOf(civ));
		}
	
		daoCompte.update(c);
	}
		public static void afficherComptes() {

			for(Compte c : daoCompte.findAll()) 
			{
				System.out.println(c);
			}

		}
		public static void main(String[] args) {
			menuPrincipal();
		}


	}
