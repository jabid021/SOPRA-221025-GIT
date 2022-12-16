package poudlard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "baguette")
public class Baguette {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;

	@OneToOne(mappedBy = "baguette")
	private Sorcier sorcier;

	public Baguette() {
	}

	public Baguette(String nom) {
		this.nom = nom;
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

	public Sorcier getSorcier() {
		return sorcier;
	}

	public void setSorcier(Sorcier sorcier) {
		this.sorcier = sorcier;
	}

	@Override
	public String toString() {
		return "Baguette [id=" + id + ", nom=" + nom + "]";
	}

}
