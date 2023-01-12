package hopital.web.dto;

import java.util.List;

public class PatientDTO {
	
	private Integer idPatient;
	private String numeroSecuriteSociale;	
	private String nom;
	private String prenom;
	private List<VisiteDTO> visites;
	
	public PatientDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public String getNumeroSecuriteSociale() {
		return numeroSecuriteSociale;
	}

	public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
		this.numeroSecuriteSociale = numeroSecuriteSociale;
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

	public List<VisiteDTO> getVisites() {
		return visites;
	}

	public void setVisites(List<VisiteDTO> visites) {
		this.visites = visites;
	}


	
}
