package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="competence")
public class Competence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="utilisation_restante")
	private int utilisationRestante;
	
	@JoinColumn(name="sorcier")
	@ManyToOne
	private Sorcier utilisateur;
	
	
	@JoinColumn(name="sort")
	@ManyToOne
	private Sort sort;
	
	public Competence() {
	}

	public Competence(int utilisationRestante, Sorcier utilisateur, Sort sort) {
		this.utilisationRestante = utilisationRestante;
		this.utilisateur = utilisateur;
		this.sort = sort;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUtilisationRestante() {
		return utilisationRestante;
	}

	public void setUtilisationRestante(int utilisationRestante) {
		this.utilisationRestante = utilisationRestante;
	}

	public Sorcier getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Sorcier utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Competence [id=" + id + ", utilisationRestante=" + utilisationRestante + ", utilisateur=" + utilisateur
				+ ", sort=" + sort + "]";
	}
	
	
}
