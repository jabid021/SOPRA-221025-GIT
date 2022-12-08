package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="label", nullable = false, length = 50)
	private String libelle;

	@Column(name="price",columnDefinition = "DECIMAL(6,2)")
	private double prix;
	
	@OneToMany(mappedBy = "produit")
	private List<Achat> ventes;
	
	
	@JoinColumn(name="vendeur")
	@ManyToOne
	private Fournisseur	fournisseur;
	
	
	public Produit() {
	}

	public Produit(String libelle, double prix,Fournisseur fournisseur) {
		this.libelle = libelle;
		this.prix = prix;
		this.fournisseur=fournisseur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	
	public List<Achat> getVentes() {
		return ventes;
	}

	public void setVentes(List<Achat> ventes) {
		this.ventes = ventes;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", fournisseur=" + fournisseur + "]";
	}
	
	

	
	
	
}
