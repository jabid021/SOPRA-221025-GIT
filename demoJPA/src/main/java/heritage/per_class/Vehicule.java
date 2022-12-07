package heritage.per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqVehi",sequenceName = "vehicule_auto_increment")
public abstract class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqVehi")
	@Column(name="id_vehicule")
	protected Integer id;
	protected String taille;
	
	
	public Vehicule() {
	}


	public Vehicule(String taille) {
		this.taille = taille;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTaille() {
		return taille;
	}


	public void setTaille(String taille) {
		this.taille = taille;
	}
	
	

}
