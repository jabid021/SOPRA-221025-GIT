package model;

public class Place {
	
	private Integer id;
	private Parking parking;
	private Taille taille;
	private int emplacement;

	public Place(Parking parking, Taille taille, int emplacement) {
		this.parking = parking;
		this.taille = taille;
		this.emplacement = emplacement;
	}
	
	public Place(Integer id,Parking parking, Taille taille, int emplacement) {
		this.id=id;
		this.parking = parking;
		this.taille = taille;
		this.emplacement = emplacement;
	}
	
	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	public int getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(int emplacement) {
		this.emplacement = emplacement;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Place [id= "+id+" , parking=" + parking + ", taille=" + taille + ", emplacement=" + emplacement + "]";
	}
	
	
}
