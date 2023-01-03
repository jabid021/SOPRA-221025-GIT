package quest.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatiereDTO {

	private Integer id;
	private String nom;
	@JsonProperty("code_quest")
	private int codeQuest;
	
	private List<Integer> filieres = new ArrayList<>();

	public MatiereDTO() {
		super();
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

	public int getCodeQuest() {
		return codeQuest;
	}

	public void setCodeQuest(int codeQuest) {
		this.codeQuest = codeQuest;
	}

	public List<Integer> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Integer> filieres) {
		this.filieres = filieres;
	}

}
