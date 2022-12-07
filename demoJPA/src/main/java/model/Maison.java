package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Maison {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	@JoinColumn(name="principal")
	@OneToOne
	private Professeur principal;
	
	public Maison() {}

	public Maison(String nom, Professeur principal) {
		this.nom = nom;
		this.principal = principal;
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

	public Professeur getPrincipal() {
		return principal;
	}

	public void setPrincipal(Professeur principal) {
		this.principal = principal;
	}

	@Override
	public String toString() {
		return "Maison [id=" + id + ", nom=" + nom + ", principal=" + principal + "]";
	}
	
	
}
