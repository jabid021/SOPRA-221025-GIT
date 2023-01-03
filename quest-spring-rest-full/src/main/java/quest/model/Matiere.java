package quest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "matiere")
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@Column(length = 25, nullable = false)
	@JsonView(Views.ViewBase.class)
	private String libelle;
	@JsonView(Views.ViewBase.class)
	private int quest;

	@Version
	@JsonView(Views.ViewBase.class)
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
