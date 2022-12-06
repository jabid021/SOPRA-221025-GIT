package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Eleve extends Sorcier{

	private int annee;
	
	@Column(name="rank", unique = true)
	private Integer rang;
	
	
	
	public Eleve() {
	}



	public Eleve(String nom, String prenom,int annee, Patronus patronus, Stats statistiques) {
		super(nom, prenom, patronus, statistiques);
		this.annee = annee;
	}



	public int getAnnee() {
		return annee;
	}



	public void setAnnee(int annee) {
		this.annee = annee;
	}



	public Integer getRang() {
		return rang;
	}



	public void setRang(Integer rang) {
		this.rang = rang;
	}



	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", statistiques=" + statistiques + ", annee="
				+ annee + ", rang=" + rang + "]";
	}
	
	
	
}
