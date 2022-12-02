package model;

public class Compte {

	protected Integer id;
	protected String mail;
	protected String password;
	
	public Compte(Integer id, String mail, String password) {

		this.id = id;
		this.mail = mail;
		this.password = password;
	}
	
	public Compte(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
	
}
