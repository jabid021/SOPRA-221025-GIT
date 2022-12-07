package heritage.per_class;

import javax.persistence.Entity;

@Entity
public class Moto extends Vehicule{

	
	public Moto() {
	}

	@Override
	public String toString() {
		return "Moto [id=" + id + ", taille=" + taille + "]";
	}
	
	
}
