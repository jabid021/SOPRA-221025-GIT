package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Obligatoire
@Entity
@Table(name="wizard")
public class Sorcier {
	
	//Obligatoire
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	@Column(name="firstname")
	private String prenom;
	private int annee;
	
	
	//Obligatoire
	public Sorcier() {}


	public Sorcier(String nom, String prenom, int annee) {
		this.nom = nom;
		this.prenom = prenom;
		this.annee = annee;
	}


	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public int getAnnee() {
		return annee;
	}



	public void setAnnee(int annee) {
		this.annee = annee;
	}


	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Sorcier [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", annee=" + annee + "]";
	}


}
