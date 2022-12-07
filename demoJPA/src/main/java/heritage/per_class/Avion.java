package heritage.per_class;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class Avion extends Vehicule {

	@Column(nullable=false)
	private String pilote;
	
	public Avion() {}

	public Avion(String taille, String pilote) {
		super(taille);
		this.pilote = pilote;
	}

	public String getPilote() {
		return pilote;
	}

	public void setPilote(String pilote) {
		this.pilote = pilote;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", taille=" + taille + ", pilote=" + pilote + "]";
	}
	
	
}
