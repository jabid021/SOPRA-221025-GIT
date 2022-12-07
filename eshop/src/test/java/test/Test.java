package test;

import java.time.LocalDate;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("6","rue rougemeont","Paris","75009");
		Client c1 = new Client("Abid","Jordan",29,LocalDate.parse("1993-05-01"));
			//c1.setAdresse(a1);
		Fournisseur f1 = new Fournisseur("Abid","Charly","AJC");
			f1.setAdresse(a1);
		Produit p1 = new Produit("Formation Java",2500.50,f1);
		Produit p2 = new Produit("SQL",1500.50,f1);
		
		
		Collections.addAll(c1.getAchats(), p1,p2);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(f1);
		em.persist(p1);
		em.persist(p2);
		em.persist(c1);
	
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();

	}

}
