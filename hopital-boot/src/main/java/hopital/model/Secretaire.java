package hopital.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@DiscriminatorValue("Secretaire")
public class Secretaire extends Compte {

	public Secretaire() {
	}

	public Secretaire(String mail, String password) {
		super(mail, password);

	}

	@Override
	public String toString() {
		return "Secretaire [id=" + getId() + ", mail=" + getLogin() + ", password=" + getPassword() + "]";
	}

}
