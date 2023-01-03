package quest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="ordinateur")
public class Ordinateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@Column(length = 15,nullable=false)
	@JsonView(Views.ViewBase.class)
	private String marque;
	@JsonView(Views.ViewBase.class)
	private int ram;
	
	
	@JoinColumn(name="stagiaire")
	@OneToOne
	@JsonView(Views.ViewOrdinateurWithStagiaire.class)
	private Stagiaire stagiaire;
	
	@Version
	@JsonView(Views.ViewBase.class)
	private int version;
	
	public Ordinateur() {
	}
	
	public Ordinateur(Integer id, String marque, int ram, Stagiaire stagiaire) {
		this.id = id;
		this.marque = marque;
		this.ram = ram;
		this.stagiaire = stagiaire;
	}
	
	public Ordinateur(String marque, int ram, Stagiaire stagiaire) {
		this.marque = marque;
		this.ram = ram;
		this.stagiaire = stagiaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + ", ram=" + ram + ", stagiaire=" + stagiaire + "]";
	}
	
	
	
}
