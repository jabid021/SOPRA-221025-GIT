package heritage.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy =InheritanceType.JOINED )
public abstract class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected String nom;
	protected String espece;
	
	public Animal() {
	}
	
	public Animal(String nom, String espece) {
		this.nom = nom;
		this.espece = espece;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", espece=" + espece + "]";
	}
	
	
	

}
