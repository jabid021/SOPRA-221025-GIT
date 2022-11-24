package model;

import java.time.LocalDate;

public class Utilisateur extends Compte {
	

	private boolean abonnement;
	private LocalDate naissance;
	private String mail;
	private String telephone;
	private  Civilite civilite; 
	


	public Utilisateur(String login, String password, String nom, String prenom, boolean abonnement,
			LocalDate naissance, String mail, String telephone, Civilite civilite) {
		super(login, password, nom, prenom);
		this.abonnement = abonnement;
		this.naissance = naissance;
		this.mail = mail;
		this.telephone = telephone;
		this.civilite = civilite;
	}

	
	
	public Utilisateur(Integer id, String login, String password, String nom, String prenom, boolean abonnement,
			LocalDate naissance, String mail, String telephone, Civilite civilite) {
		super(id, login, password, nom, prenom);
		this.abonnement = abonnement;
		this.naissance = naissance;
		this.mail = mail;
		this.telephone = telephone;
		this.civilite = civilite;
	}



	public boolean isAbonnement() {
		return abonnement;
	}

	public void setAbonnement(boolean abonnement) {
		this.abonnement = abonnement;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	
	@Override
	public String toString() {
		return "Utilisateur [id= "+id+", abonnement=" + abonnement + ", naissance=" + naissance + ", mail=" + mail + ", telephone="
				+ telephone + ", civilite=" + civilite + ", login=" + login + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}

	
	

}
