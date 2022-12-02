package model;

import java.time.LocalDate;

public class Visite {
	private int id;
	private Patient patient;
	private Medecin medecin;
	private double prix =20;
	private int salle;
	private LocalDate dateVisite;
	
	
	public Visite(int id, Patient patient, Medecin medecin, double prix, int salle, LocalDate dateVisite) {
		this.id = id;
		this.patient = patient;
		this.medecin = medecin;
		this.prix = prix;
		this.salle = salle;
		this.dateVisite = dateVisite;
	}
	

	public Visite(Patient patient, Medecin medecin) {
		this.patient = patient;
		this.medecin = medecin;
		this.dateVisite = LocalDate.now();
		this.salle = medecin.getSalle();
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getSalle() {
		return salle;
	}


	public void setSalle(int salle) {
		this.salle = salle;
	}


	public LocalDate getDateVisite() {
		return dateVisite;
	}


	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}


	@Override
	public String toString() {
		return "Visite [id=" + id + ", patient=" + patient + ", medecin=" + medecin.getId() + ", prix=" + prix + ", salle="
				+ salle + ", dateVisite=" + dateVisite + "]";
	}
	

}
