package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOBaguette;
import dao.DAOCompetence;
import dao.DAOMaison;
import dao.DAOSorcier;
import dao.DAOSort;
import dao.IDAOBaguette;
import dao.IDAOCompetence;
import dao.IDAOMaison;
import dao.IDAOSorcier;
import dao.IDAOSort;

public class Singleton {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
	
	
	private IDAOSorcier daoSorcier = new DAOSorcier();
	private IDAOSort daoSort=new DAOSort();
	private IDAOBaguette daoBaguette = new DAOBaguette();
	private IDAOMaison daoMaison=new DAOMaison();
	private IDAOCompetence daoCompetence = new DAOCompetence();
	
	
	private static Singleton instance;
	
	
	private Singleton() {}

	
	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}


	public IDAOSorcier getDaoSorcier() {
		return daoSorcier;
	}


	public void setDaoSorcier(IDAOSorcier daoSorcier) {
		this.daoSorcier = daoSorcier;
	}


	public IDAOSort getDaoSort() {
		return daoSort;
	}


	public void setDaoSort(IDAOSort daoSort) {
		this.daoSort = daoSort;
	}


	public IDAOBaguette getDaoBaguette() {
		return daoBaguette;
	}


	public void setDaoBaguette(IDAOBaguette daoBaguette) {
		this.daoBaguette = daoBaguette;
	}


	public IDAOMaison getDaoMaison() {
		return daoMaison;
	}


	public void setDaoMaison(IDAOMaison daoMaison) {
		this.daoMaison = daoMaison;
	}


	public IDAOCompetence getDaoCompetence() {
		return daoCompetence;
	}


	public void setDaoCompetence(IDAOCompetence daoCompetence) {
		this.daoCompetence = daoCompetence;
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
