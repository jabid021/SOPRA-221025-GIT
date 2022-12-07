package heritage.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dog")
@PrimaryKeyJoinColumn(name = "id_chien")
public class Chien extends Animal{
	
	private boolean mechant;
	
	
	public Chien() {
	}

	

	public Chien(String nom, String espece, boolean mechant) {
		super(nom, espece);
		this.mechant = mechant;
	}



	public boolean isMechant() {
		return mechant;
	}


	public void setMechant(boolean mechant) {
		this.mechant = mechant;
	}



	@Override
	public String toString() {
		return "Chien [id=" + id + ", nom=" + nom + ", espece=" + espece + ", mechant=" + mechant + "]";
	}
	
	

}
