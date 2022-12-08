package context;

import java.util.LinkedList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOCompte;
import dao.DAOPatient;
import dao.DAOVisite;
import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import model.Patient;

public class Singleton {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");

	private LinkedList<Patient> fileAttente = new LinkedList();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOPatient daoPatient = new DAOPatient();
	private IDAOVisite daoVisite = new DAOVisite();


	private static Singleton instance;


	private Singleton() {}


	public static Singleton getInstance() {
		if(instance==null)
		{
			instance=new Singleton();
		}
		return instance;
		
	}
	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}



	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}
	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}
	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}
	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}
	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}
	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}
	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}










}
