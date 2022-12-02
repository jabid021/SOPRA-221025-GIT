package model;

public class Secretaire extends Compte {

	public Secretaire(Integer id, String mail, String password) {
		super(id, mail, password);

	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", mail=" + mail + ", password=" + password + "]";
	}	
	

	
}
