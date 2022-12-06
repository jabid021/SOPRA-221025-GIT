package context;

import java.util.LinkedList;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAOPatientJDBC;
import dao.jdbc.DAOVisiteJDBC;
import model.Patient;

public class Singleton {


	private LinkedList<Patient> fileAttente = new LinkedList();
	private IDAOCompte daoCompte = new DAOCompteJDBC();
	private IDAOPatient daoPatient = new DAOPatientJDBC();
	private IDAOVisite daoVisite = new DAOVisiteJDBC();


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










}
