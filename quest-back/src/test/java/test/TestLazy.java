package test;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Filiere;
import model.Matiere;
import model.Stagiaire;

public class TestLazy {


	//Acces aux stagiaires APRES le em.close ❌
	//Impossible de faire des filtres sur les stagiaires ❌
	public static List<Filiere> ShowLazy() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("from Filiere").getResultList();

		em.close();
		return filieres;
	}

	//Acces aux stagiaires APRES le em.close ❌
	//Possible de faire des filtres sur les stagiaires ✔
	public static List<Filiere> ShowFilter() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT f from Filiere f  join f.stagiaires s where s.nom like '%A%'").getResultList();
		em.close();
		return filieres;
	}

	//Acces aux stagiaires APRES le em.close ❌
	//Possible de faire des filtres sur les stagiaires ✔
	//Les filieres n'ayant pas de stagiaire ne sont pas return ❌
	//Les filieres ayant plusieurs stagiaire return des doublons ❌
	public static List<Filiere> ShowJoin() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT f from Filiere f  join f.stagiaires").getResultList();
		em.close();
		return filieres;
	}


	//Acces aux stagiaires APRES le em.close ❌
	//Possible de faire des filtres sur les stagiaires ✔
	//Les filieres n'ayant pas de stagiaire sont pas return ✔
	//Les filieres ayant plusieurs stagiaire return des doublons ❌
	public static List<Filiere> ShowLeftJoin() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT f from Filiere f left join f.stagiaires").getResultList();
		em.close();
		return filieres;
	}


	//Acces aux stagiaires APRES le em.close ❌
	//Possible de faire des filtres sur les stagiaires ✔
	//Les filieres n'ayant pas de stagiaire sont pas return ✔
	//Les filieres ayant plusieurs stagiaire return pas de doublons ✔
	public static List<Filiere> ShowLeftJoinDistinct() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT distinct f from Filiere f left join f.stagiaires").getResultList();
		em.close();
		return filieres;
	}


	//Acces aux stagiaires APRES le em.close ✔
	//Possible de faire des filtres sur les stagiaires ✔
	//Les filieres n'ayant pas de stagiaire sont pas return ✔
	//Les filieres ayant plusieurs stagiaire return pas de doublons ✔
	public static List<Filiere> ShowLeftJoinDistinctAfterClose() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT distinct f from Filiere f left join fetch f.stagiaires").getResultList();
		em.close();
		return filieres;
	}



	//Acces aux stagiaires APRES le em.close ✔
	//Possible de faire des filtres sur les stagiaires ✔
	//Les filieres n'ayant pas de stagiaire sont pas return ✔
	//Les filieres ayant plusieurs stagiaire return pas de doublons ✔
	public static List<Filiere> ShowLeftJoinDistinctAfterCloseMatiere() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT distinct f from Filiere f left join fetch f.matieres").getResultList();
		em.close();
		return filieres;
	}



	//Acces aux stagiaires + matieres APRES le em.close ❌
	//Possible de faire des filtres sur les stagiaires ✔
	//Les filieres n'ayant pas de stagiaire sont pas return ✔
	//Les filieres ayant plusieurs stagiaire return pas de doublons ✔
	public static List<Filiere> ShowLeftJoinDistinctAfterCloseMatiereAndStagiaireNotWorking() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT distinct f from Filiere f left join fetch f.matieres left join fetch f.stagiaires").getResultList();
		em.close();
		return filieres;
	}

	//Acces aux stagiaires + matieres APRES le em.close ✔
	//Possible de faire des filtres sur les stagiaires ✔
	//Les filieres n'ayant pas de stagiaire sont pas return ✔
	//Les filieres ayant plusieurs stagiaire return pas de doublons ✔
	public static List<Filiere> requeteQuiMarche() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("SELECT distinct f from Filiere f left join fetch f.matieres").getResultList();
		filieres = em.createQuery("SELECT distinct f from Filiere f left join fetch f.stagiaires").getResultList();
		em.close();
		return filieres;
	}

	public static void main(String[] args) {

		List<Filiere> filieres = requeteQuiMarche();


		for(Filiere f : filieres) 
		{
			System.out.println(f.getLibelle());
			System.out.println("Voici les stagiaires de cette filiere :  ");
			for(Stagiaire s : f.getStagiaires()) 
			{
				System.out.println(s);
			}

			System.out.println("");

			System.out.println("Voici les matieres :");
			for(Matiere m : f.getMatieres()) 
			{
				System.out.println(m);
			}
		}


	}
}
