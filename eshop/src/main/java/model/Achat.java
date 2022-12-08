package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="achat")
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Integer id;
	
	
	@JoinColumn(name="client")
	@ManyToOne
	private Client client;
	
	
	@JoinColumn(name="produit")
	@ManyToOne
	private Produit produit;
	
	private LocalDate dateAchat;
	private LocalTime heureAchat;
	
	
	
	public Achat() {
	}

	public Achat(Client client, Produit produit) {
		this.client = client;
		this.produit = produit;
		this.dateAchat=LocalDate.now();
		this.heureAchat=LocalTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	public LocalTime getHeureAchat() {
		return heureAchat;
	}

	public void setHeureAchat(LocalTime heureAchat) {
		this.heureAchat = heureAchat;
	}

	@Override
	public String toString() {
		return "Achat [id=" + id + ", client=" + client + ", produit=" + produit + ", dateAchat=" + dateAchat
				+ ", heureAchat=" + heureAchat + "]";
	}

	
	
}
