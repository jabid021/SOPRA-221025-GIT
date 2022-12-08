package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Medecin extends Compte {

	@OneToMany(mappedBy = "medecin")
	private List<Visite> visites = new ArrayList(); 
	
    private transient int salle;
    
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
