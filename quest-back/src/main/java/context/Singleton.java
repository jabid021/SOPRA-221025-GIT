package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOFiliere;
import dao.DAOMatiere;
import dao.DAOOrdinateur;
import dao.DAOStagiaire;
import dao.IDAOFiliere;
import dao.IDAOMatiere;
import dao.IDAOOrdinateur;
import dao.IDAOStagiaire;

public class Singleton {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("quest");
	
	
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOStagiaire daoStagiaire=new DAOStagiaire();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private IDAOFiliere daoFiliere=new DAOFiliere();
	
	
	
	private static Singleton instance;
	
	
	private Singleton() {}

	
	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}



	public IDAOMatiere getDaoMatiere() {
		return daoMatiere;
	}


	public void setDaoMatiere(IDAOMatiere daoMatiere) {
		this.daoMatiere = daoMatiere;
	}


	public IDAOStagiaire getDaoStagiaire() {
		return daoStagiaire;
	}


	public void setDaoStagiaire(IDAOStagiaire daoStagiaire) {
		this.daoStagiaire = daoStagiaire;
	}


	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}


	public void setDaoOrdinateur(IDAOOrdinateur daoOrdinateur) {
		this.daoOrdinateur = daoOrdinateur;
	}


	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}


	public void setDaoFiliere(IDAOFiliere daoFiliere) {
		this.daoFiliere = daoFiliere;
	}


	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	
	
}
