package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Sorcier;

public class Test {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		
		
		Sorcier s1 = new Sorcier("Potter","Harry",1);

		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(s1);
		
		em.getTransaction().commit();
		
		
		
		Sorcier s = em.find(Sorcier.class,1);
		System.out.println(s);
	
		em.close();
		emf.close();
	}

}
