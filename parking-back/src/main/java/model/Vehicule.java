package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicule {
	protected Integer id;
	protected String marque;
	protected String plaque;
	protected List<Carburant> carburants = new ArrayList();
	protected Taille taille;
	protected Utilisateur utilisateur;
	
	public Vehicule(String marque, String plaque, Taille taille, Utilisateur utilisateur) {
		this.marque = marque;
		this.plaque = plaque;
		this.taille = taille;
		this.utilisateur = utilisateur;
	}

	
	public Vehicule(Integer id,String marque, String plaque, Taille taille, Utilisateur utilisateur) {
		this.id=id;
		this.marque = marque;
		this.plaque = plaque;
		this.taille = taille;
		this.utilisateur = utilisateur;
	}

	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public List<Carburant> getCarburants() {
		return carburants;
	}

	public void setCarburants(List<Carburant> carburants) {
		this.carburants = carburants;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}
