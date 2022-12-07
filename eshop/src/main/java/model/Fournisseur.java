package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {

	@Column(name="company",length=30)
	private String societe;
	
	
	public Fournisseur() {
	}


	public Fournisseur(String prenom, String nom, String societe) {
		super(prenom, nom);
		this.societe = societe;
	}


	public String getSociete() {
		return societe;
	}


	public void setSociete(String societe) {
		this.societe = societe;
	}


	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", societe=" + societe + "]";
	}
	
	
	
}
