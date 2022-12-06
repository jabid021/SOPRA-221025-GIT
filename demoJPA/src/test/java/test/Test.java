package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Eleve;
import model.Patronus;
import model.Professeur;
import model.Sorcier;
import model.Stats;

public class Test {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		Stats stat1 = new Stats(99,99);
		
		Eleve s1 = new Eleve("Potter","Harry",1,Patronus.Cerf,stat1);
		s1.setRang(1);
		Eleve s2 = new Eleve("Weasley","Ron",1,Patronus.Chien,new Stats(20,15));
		Eleve s3 = new Eleve("Granger","Hermione",1,Patronus.Loutre,new Stats(50,50));
		
		Professeur p1 = new Professeur("Dumbledore","Albus",Patronus.Phoenix,new Stats(9001,9001),"Metamorphose");

		
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(p1);
		em.getTransaction().commit();
		
	
		Sorcier s = em.find(Sorcier.class,2);
		System.out.println(s);
	
		em.close();
		emf.close();
	}

}
