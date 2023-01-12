package hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Compte {

	@OneToMany(mappedBy = "medecin")
	@JsonView(Views.ViewMedecinDetail.class)
	private List<Visite> visites = new ArrayList<>();

	@JsonView(Views.ViewBase.class)
	private transient int salle;

	public Medecin() {
	}

	public Medecin(String mail, String password) {
		super(mail, password);

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
		return "Medecin [salle=" + salle + ", id=" + getId() + "]";
	}

}
