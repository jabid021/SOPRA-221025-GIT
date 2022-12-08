package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import heritage.joined.Chat;
import heritage.joined.Chien;
import heritage.per_class.Avion;
import heritage.per_class.Voiture;
import model.Baguette;
import model.Competence;
import model.Eleve;
import model.Maison;
import model.Patronus;
import model.Professeur;
import model.Sort;
import model.Stats;

public class Test {

	
	public static void demoInsertData() 
	{
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		Professeur p1 = new Professeur("Dumbledore","Albus",Patronus.Phoenix,new Stats(9001,9001),"Metamorphose");
		Professeur p2 = new Professeur("Severus ","Rogue",Patronus.Coccinelle,new Stats(50,90),"PAS GENTIL");
	

		Maison m1 = new Maison("Gryffondor",p1);
		Maison m2 = new Maison("Serpentard",p2);
		
		Baguette b1 = new Baguette("baguette1");
		Baguette b2 = new Baguette("baguette2");
		
		Sort spell1=new Sort("Lumos",0);
		Sort spell2 = new Sort("Wingardium LeviOOOsa",10);
		
		
		Stats stat1 = new Stats(99,99);
		
		Eleve s1 = new Eleve(null,"Harry",1,Patronus.Cerf,stat1,m1);
		s1.setBaguette(b1);
	//	s1.getSorts().add(spell1);
		s1.setRang(1);
		Eleve s2 = new Eleve("Weasley","Ron",1,Patronus.Chien,new Stats(20,15),m1);
		Eleve s3 = new Eleve("Granger","Hermione",1,Patronus.Loutre,new Stats(50,50),m1);
		
		//s3.getSorts().add(spell2);
		
		
		
		Competence comp1 = new Competence(4, s1, spell1);
		Competence comp2 = new Competence(5, s3, spell2);
		
		/*Chien c1 = new Chien("wouf","bichon",true);
		Chat c2 = new Chat("miaou","ragdoll",8,"toutes les couleurs");
		
		Voiture v1 = new Voiture("Moyen", 4, "BMW");
		Avion a1 = new Avion("Grand","Le Pilote");
		*/
		
		EntityManager em  = emf.createEntityManager();
		
	
		
		em.getTransaction().begin();
		
		
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(m1);
		em.persist(m2);
		em.persist(b1);
		em.persist(b2);
		em.persist(spell1);
		em.persist(spell2);
		em.persist(p1);
		em.persist(p2);
		em.persist(comp1);
		em.persist(comp2);
		
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
		
		
		/*em=emf.createEntityManager();
		
		Baguette select = em.find(Baguette.class, 1);
		System.out.println(select);
		
		System.out.println(select.getSorcier());
		
		em.close();*/
		emf.close();
	
	}

	
	public static void demoCrud() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		
		Maison m = new Maison("TEST",null);
		m.setId(45);
		
		EntityManager em = emf.createEntityManager();
		
		//findById
		//Maison m=em.find(Maison.class, 3);
		
		//findAll
		//System.out.println(em.createQuery("from Maison").getResultList());
		
		em.getTransaction().begin();
		
		//Insert
		//em.persist(m3);
		
		//Update
		//m3=em.merge(m3);
		em.merge(m);
		
		//delete
		//em.remove(m);
		
		em.getTransaction().commit();
		
		em.close();

	
		emf.close();
		
		
		
		//persist(m) => m est managed
		//find(id x ) => return un objet m qui est managed
		//findAll() => retun une liste d'objets qui sont tous managed
		//remove(m) => m DOIT ETRE MANAGED
		//m2=merge(m) => m N'EST PAS MANAGED, m2 EST Managed
	}
	
	public static void main(String[] args) {
	
		
		
		
		demoCrud();
		
	
	}

}
