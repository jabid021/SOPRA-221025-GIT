package model;
import java.util.List;
import model.Adresse;
import java.util.ArrayList;

//Bien penser à la liste de PLACE
public class Parking {

	private Integer id;
	private double prix;
	private int etage;
	private boolean handicap;
	private String description;
	private Responsable responsable;
	private Adresse adresse;
	private List<Place> listePlace =new ArrayList();
	
	public Parking(double prix, int etage, boolean handicap, String description, Responsable responsable,
			Adresse adresse) {
		this.prix = prix;
		this.etage = etage;
		this.handicap = handicap;
		this.description = description;
		this.responsable = responsable;
		this.adresse = adresse;
	}

	public Parking(Integer id,double prix, int etage, boolean handicap, String description, Responsable responsable,
			Adresse adresse) {
		this.id=id;
		this.prix = prix;
		this.etage = etage;
		this.handicap = handicap;
		this.description = description;
		this.responsable = responsable;
		this.adresse = adresse;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public boolean isHandicap() {
		return handicap;
	}

	public void setHandicap(boolean handicap) {
		this.handicap = handicap;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Place> getListePlace() {
		return listePlace;
	}

	public void setListePlace(List<Place> listePlace) {
		this.listePlace = listePlace;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Parking [id= "+id+", prix=" + prix + ", etage=" + etage + ", handicap=" + handicap + ", description=" + description
				+ ", responsable=" + responsable + ", adresse=" + adresse + "]";
	}
	
	
	
	
		
}
