package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="matiere")
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=25,nullable=false)
	private String libelle;
	private int quest;
	
	@Version
	private int version;
	
	public Matiere() {
	}
	
	public Matiere(Integer id, String libelle, int quest) {
		this.id = id;
		this.libelle = libelle;
		this.quest = quest;
	}
	
	
	public Matiere(String libelle, int quest) {
		this.libelle = libelle;
		this.quest = quest;
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


	public int getQuest() {
		return quest;
	}


	public void setQuest(int quest) {
		this.quest = quest;
	}

	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + ", quest=" + quest + "]";
	}
	
	
	
}
