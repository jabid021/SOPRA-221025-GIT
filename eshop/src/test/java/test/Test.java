package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		Personne p1 = new Personne("Abid","Jordan");
		
		Produit f1 = new Produit("Formation Java",2500.50);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(f1);
		
		
		em.getTransaction().commit();
		
		System.out.println(p1);
		System.out.println(f1);
		
		em.close();
		emf.close();

	}

}
