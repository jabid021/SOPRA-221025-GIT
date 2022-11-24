package model;

import java.time.LocalDate;

public class Reservation {
	private Integer id;
	private LocalDate jour;
	private double prix;
	private boolean paye;
	private Place place;
	private Vehicule vehicule;

	public Reservation(LocalDate jour,boolean paye, Place place, Vehicule vehicule) {
		this.jour = jour;
		this.prix = place.getParking().getPrix();
		this.paye = paye;
		this.place = place;
		this.vehicule = vehicule;
	}
	
	public Reservation(Integer id,LocalDate jour, double prix, boolean paye, Place place, Vehicule vehicule) {
		this.id=id;
		this.jour = jour;
		this.prix = prix;
		this.paye = paye;
		this.place = place;
		this.vehicule = vehicule;
	}

	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate jour) {
		this.jour = jour;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public boolean isPaye() {
		return paye;
	}

	public void setPaye(boolean paye) {
		this.paye = paye;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Reservation [id= "+id+", jour=" + jour + ", prix=" + prix + ", paye=" + paye + ", place=" + place + ", vehicule="
				+ vehicule + "]";
	}
	
	
}
