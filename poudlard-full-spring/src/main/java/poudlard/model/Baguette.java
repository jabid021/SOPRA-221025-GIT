package poudlard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "baguette")
public class Baguette {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 25, nullable = false)
	@Size(min = 2, max = 25, message = "Le nom doit comporter entre 2 et 25 caractères")
	private String nom;

	@OneToOne(mappedBy = "baguette")
	private Sorcier sorcier;
	
	@Version
	private int version;

	public Baguette(Integer id,
			@Size(min = 2, max = 25, message = "Le nom doit comporter entre 2 et 25 caractères") String nom,
			Sorcier sorcier) {
		super();
		this.id = id;
		this.nom = nom;
		this.sorcier = sorcier;
	}

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "Baguette [id=" + id + ", nom=" + nom + "]";
	}



}
