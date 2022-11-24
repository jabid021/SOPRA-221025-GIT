package model;

public class Adresse {

	private String  numero;
	private String cp;
	private String voie; 
	private String ville;
	
	public Adresse(String numero, String voie, String ville,String cp) {
		this.numero = numero;
		this.cp = cp;
		this.voie = voie;
		this.ville = ville;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", cp=" + cp + ", voie=" + voie + ", ville=" + ville + "]";
	}




}
