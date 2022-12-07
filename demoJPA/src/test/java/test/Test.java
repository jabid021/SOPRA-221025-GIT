package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import heritage.joined.Animal;
import heritage.joined.Chat;
import heritage.joined.Chien;
import heritage.per_class.Avion;
import heritage.per_class.Vehicule;
import heritage.per_class.Voiture;
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

		
		Chien c1 = new Chien("wouf","bichon",true);
		Chat c2 = new Chat("miaou","ragdoll",8,"toutes les couleurs");
		
		Voiture v1 = new Voiture("Moyen", 4, "BMW");
		Avion a1 = new Avion("Grand","Le Pilote");
		
		
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(p1);
		em.persist(c1);
		em.persist(c2);
		em.persist(v1);
		em.persist(a1);
		em.getTransaction().commit();
		


		
	/*	List<Sorcier> poudlard = em.createQuery("from Sorcier").getResultList();
		
		for(Sorcier s : poudlard) 
		{
			System.out.println(s);
		}
		
		//Sorcier s = em.find(Sorcier.class,4);
		//System.out.println(s);
	
		
		List<Animal> animaux = em.createQuery("from Animal").getResultList();
		
		System.out.println(animaux);
		
		List<Vehicule> parking = em.createQuery("from Vehicule").getResultList();
		
		System.out.println(parking);*/
		
		em.close();
		emf.close();
	}

}
