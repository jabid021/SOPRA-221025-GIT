package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Admin;
import model.Adresse;
import model.Carburant;
import model.Civilite;
import model.Moto;
import model.Parking;
import model.Place;
import model.Reservation;
import model.Responsable;
import model.Taille;
import model.Utilisateur;
import model.Voiture;

public class Test {

	public static void main(String[] args) {


		LocalDate naissance = LocalDate.parse("1993-05-01");
		LocalDate naissance2 = LocalDate.parse("1994-05-01");



		//-----------------Groupe 1 ----------------////
		//        Admin admin;
		//        Responsable resp1;
		//        Utilisateur user1;
		//        Utilisateur user2;

		Admin admin = new Admin("admin","admin", "Jordan", "Abid");
		Responsable resp1 = new Responsable("TotoTiti","yzf","Toto" , "Titi", "ParkMe");
		Utilisateur user1 = new Utilisateur("yayager", "abcv", "yaya", "ger", true, naissance, "ger@yahoo.fr","0656768797",Civilite.Homme);
		Utilisateur user2 = new Utilisateur("jeantiti", "azerty", "jean", "titi", false, naissance2, "jean.titi@yahoo.fr","0614638798", Civilite.Homme);


		//----------------- FIN Groupe 1 ----------------////




		//-----------------Groupe 2 ----------------////
		//Vehicules user1
		
		Voiture voiture1 = new Voiture("BMW","TH78AA",Taille.Moyen,user1,4,true);
		voiture1.getCarburants().add(Carburant.Diesel);
		voiture1.getCarburants().add(Carburant.Electrique);
		
		
		Voiture voiture2 = new Voiture("TESLA","TH78AB",Taille.Moyen,user1,4,true);
		voiture2.getCarburants().add(Carburant.Electrique);
		
		
		
		Moto moto1 = new Moto("YAMAHA", "DB580F", user1,2);
		moto1.getCarburants().add(Carburant.Essence);
		
		//-----------------Fin Groupe 2 ----------------////




		//-----------------Groupe 3 ----------------////
		Adresse adresse = new Adresse("17","Avenue du Lamantin","Paris","75007");

		//adresse + resp1
		List<Place> listePlace =new ArrayList<>();
		//Collections.addAll(listePlace, p1,p2,p3);
		String description ="Viens dans mon super parking on y est bien";
		Parking parking1 = new Parking(75.0, 3, true, description, resp1, adresse);
		//-----------------FIN Groupe 3----------------////



		//-----------------Groupe 4 ----------------////
		//Place de parking1
		Place p1 = new Place(parking1, Taille.Grand, 3001);
		Place p2= new Place(parking1, Taille.Moyen, 3002);
		Place p3= new Place(parking1, Taille.Petit, 5);

		//voiture1 + p1, voiture1+p2, moto1+p3
		Reservation resa1 = new Reservation(LocalDate.parse("2022-11-09"), false, p1, voiture1);
		Reservation resa2 = new Reservation(LocalDate.now(),  false, p2, voiture1);
		Reservation resa3 = new Reservation(LocalDate.now().plusDays(1),  false, p3, moto1);
		
		//-----------------Fin Groupe 4----------------////
		
		System.out.println(resa1);
		
		
	
		
		
		
	}

}
