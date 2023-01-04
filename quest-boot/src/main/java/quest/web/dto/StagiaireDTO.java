package quest.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StagiaireDTO {
	private Integer identifiant;
	private String nom;
	private String prenom;
	private String email;
	@JsonProperty("id_filiere")
	private Integer idFiliere;
	@JsonProperty("nom_filiere")
	private String nomFiliere;
	@JsonProperty("debut_filiere")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate debutFiliere;
	@JsonProperty("fin_filiere")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate finFiliere;
	@JsonProperty("debut_filiere_string")
	private String debutFiliereString;
	@JsonProperty("fin_filiere_string")
	private String finFiliereString;

	public StagiaireDTO() {
		super();
	}

	public Integer getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Integer idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getNomFiliere() {
		return nomFiliere;
	}

	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}

	public LocalDate getDebutFiliere() {
		return debutFiliere;
	}

	public void setDebutFiliere(LocalDate debutFiliere) {
		this.debutFiliere = debutFiliere;
	}

	public LocalDate getFinFiliere() {
		return finFiliere;
	}

	public void setFinFiliere(LocalDate finFiliere) {
		this.finFiliere = finFiliere;
	}

	public String getDebutFiliereString() {
		return debutFiliereString;
	}

	public void setDebutFiliereString(String debutFiliereString) {
		this.debutFiliereString = debutFiliereString;
	}

	public String getFinFiliereString() {
		return finFiliereString;
	}

	public void setFinFiliereString(String finFiliereString) {
		this.finFiliereString = finFiliereString;
	}

}
