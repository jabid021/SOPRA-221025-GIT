package heritage.per_class;

import javax.persistence.Entity;

//@Entity
public class Voiture extends Vehicule{

	private int nbRoues;
	
	private String marque;
	
	public Voiture() {
	}

	public Voiture(String taille, int nbRoues, String marque) {
		super(taille);
		this.nbRoues = nbRoues;
		this.marque = marque;
	}

	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", taille=" + taille + ", nbRoues=" + nbRoues + ", marque=" + marque + "]";
	}
	
	
}
