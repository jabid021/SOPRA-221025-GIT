package model;

public class Admin extends Compte{

	public Admin(String login, String password, String nom, String prenom) {
		super(login, password, nom, prenom);
	}
	
	

	public Admin(Integer id, String login, String password, String nom, String prenom) {
		super(id, login, password, nom, prenom);
	}



	@Override
	public String toString() {
		return "Admin [id= "+id+" ,login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + "]";
	}


	
	

}
