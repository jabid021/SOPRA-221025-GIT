package poudlard.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.text.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "maison")
public class Maison {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@JsonView(Views.ViewBase.class)
	private String nom;

	@JoinColumn(name = "principal_id")
	@OneToOne
	@JsonView(Views.ViewBase.class)
	private Professeur principal;

	@OneToMany(mappedBy = "maison")
	@JsonView(Views.ViewBase.class)
	private List<Eleve> eleves;

	public Maison() {
	}

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

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	@Override
	public String toString() {
		return "Maison [id=" + id + ", nom=" + nom + ", principal=" + principal + "]";
	}

}
