package model;

public class Responsable extends Compte{
	
	private String entreprise;

	public Responsable(String login, String password, String nom, String prenom, String entreprise) {
		super(login, password, nom, prenom);
		this.entreprise = entreprise;
	}
	
	

	public Responsable(Integer id, String login, String password, String nom, String prenom, String entreprise) {
		super(id, login, password, nom, prenom);
		this.entreprise = entreprise;
	}



	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	@Override
	public String toString() {
		return "Responsable [id = "+id+", entreprise=" + entreprise + ", login=" + login + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}

	


	
	

}
