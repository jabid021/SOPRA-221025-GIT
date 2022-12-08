package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Achat;
import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		
		/*Adresse a1 = new Adresse("6","rue rougemeont","Paris","75009");
		Client c1 = new Client("Abid","Jordan",29,LocalDate.parse("1993-05-01"));
			//c1.setAdresse(a1);
		Fournisseur f1 = new Fournisseur("Abid","Charly","AJC");
			f1.setAdresse(a1);
		Produit p1 = new Produit("Formation Java",2500.50,f1);
		Produit p2 = new Produit("SQL",1500.50,f1);
		
		Achat ach1 = new Achat(c1,p1);
		
		Achat ach2 = new Achat(c1,p2);*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopJPA");
		EntityManager em = emf.createEntityManager();
		
		Produit p = em.find(Produit.class, 1);
		
		System.out.println(p.getLibelle());
		
		
		
		
		
		//em.getTransaction().begin();
		//em.remove(client);
		//em.persist(f1);
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(c1);
		//em.persist(ach1);
		//em.persist(ach2);
		//em.getTransaction().commit();
		em.close();
		System.out.println("Le fournisseur de ce produit est : "+p.getFournisseur());
		System.out.println("Ce produit a ete vendu "+p.getVentes().size()+" fois");
		emf.close();

	}

}
