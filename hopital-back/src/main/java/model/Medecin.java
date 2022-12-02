package model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Compte {

	private List<Visite> visites = new ArrayList(); 
    private int salle;
    
    public Medecin(Integer id, String mail, String password) {
		super(id, mail, password);
 
	}

    

	public List<Visite> getVisites() {
		return visites;
	}



	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}



	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}


	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", id=" + id +"]";
	}



	



}
