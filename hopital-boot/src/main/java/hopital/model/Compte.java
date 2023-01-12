package hopital.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", columnDefinition = "enum('Medecin', 'Secretaire')")
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private String login;
	@JsonView(Views.ViewBase.class)
	private String password;

	public Compte() {
	}

	public Compte(String mail, String password) {
		this.login = mail;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String mail) {
		this.login = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", mail=" + login + ", password=" + password + "]";
	}

}
