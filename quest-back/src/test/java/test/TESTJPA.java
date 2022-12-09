package test;

import java.time.LocalDate;

import javax.persistence.EntityManagerFactory;

import model.Filiere;
import model.Matiere;
import model.Ordinateur;
import model.Stagiaire;

public class TESTJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Singleton.getInstance().getEmf();
		IDAOFiliere daoF = Singleton.getInstance().getDaoFiliere();
		IDAOMatiere daoM= Singleton.getInstance().getDaoMatiere();
		IDAOOrdinateur daoO= Singleton.getInstance().getDaoOrdinateur();
		IDAOStagiaire daoS=Singleton.getInstance().getDaoStagiaire();
		
		
		Filiere f1 = new Filiere("Test filiere",LocalDate.parse("2022-01-01"),LocalDate.parse("2020-05-01"));
		

		int nbFiliere = daoF.findAll().size();
		int nbStagiaire = daoS.findAll().size();
		f1=daoF.save(f1);
		
		if((nbFiliere+1)==daoF.findAll().size()) 
		{
			System.out.println("Insert filiere est OK");
		}
		else 
		{
			System.out.println("Probleme insert filiere");
		}
	
		Stagiaire s1 = new Stagiaire("Test","Test","toto@gmail.com",f1);
	
		s1=daoS.save(s1);
		
		if((nbStagiaire+1)==daoF.findAll().size()) 
		{
			System.out.println("Insert stagiaire est OK");
		}
		else 
		{
			System.out.println("Probleme insert stagiaire" );
		}
		
		
		daoS.delete(s1);
		daoF.delete(f1);
		
		
		if((nbStagiaire)==daoF.findAll().size()) 
		{
			System.out.println("delete stagiaire est OK");
		}
		else 
		{
			System.out.println("Probleme delete stagiaire" );
		}
		
		
		if(nbFiliere==daoF.findAll().size()) 
		{
			System.out.println("delete filiere est OK");
		}
		else 
		{
			System.out.println("Probleme delete filiere");
		}
	
		
	
		emf.close();
	}

}
