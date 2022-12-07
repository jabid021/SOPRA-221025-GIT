package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("student")
public class Eleve extends Sorcier{

	private int annee;
	
	@Column(name="rank", unique = true)
	private Integer rang;
	
	
	//@XToY => Dans la classe Eleve,  
	//X represente le nomdre d'eleves dans une maison
	//Y represente le nombre de maison d'un eleve
	
	@JoinColumn(name="house")
	@ManyToOne
	private Maison maison;
	
	public Eleve() {
	
	}



	public Eleve(String nom, String prenom,int annee, Patronus patronus, Stats statistiques,Maison maison) {
		super(nom, prenom, patronus, statistiques);
		this.annee = annee;
		this.maison=maison;
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


	

	public Maison getMaison() {
		return maison;
	}



	public void setMaison(Maison maison) {
		this.maison = maison;
	}



	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", statistiques=" + statistiques + ", annee="
				+ annee + ", rang=" + rang + ", maison=" + maison + "]";
	}



	
	
}
