package hopital.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Visite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private double prix = 20;
	@JsonView(Views.ViewBase.class)
	private int salle;
	@Column(name = "date_visite")
	@JsonView(Views.ViewBase.class)
	private LocalDate dateVisite;

	@ManyToOne
	@JoinColumn(name = "id_patient")
	@JsonView(Views.ViewVisite.class)
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "id_medecin")
	@JsonView(Views.ViewVisite.class)
	private Medecin medecin;

	public Visite() {
	}

	public Visite(Patient patient, Medecin medecin, double prix, int salle, LocalDate dateVisite) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "Visite [id=" + id + ", patient=" + patient + ", medecin=" + medecin.getId() + ", prix=" + prix
				+ ", salle=" + salle + ", dateVisite=" + dateVisite + "]";
	}

}
