package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne{
	
	@Column(columnDefinition = "int(2)")
	private int age;
	
	@Column(name="birthdate")
	private LocalDate naissance;

	@OneToMany(mappedBy = "client")
	private List<Achat> achats = new ArrayList();
	
	public Client() {}
	
	public Client(String prenom, String nom, int age, LocalDate naissance) {
		super(prenom, nom);
		this.age = age;
		this.naissance = naissance;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public LocalDate getNaissance() {
		return naissance;
	}



	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}



	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", age=" + age
				+ ", naissance=" + naissance + "]";
	}

	
	
	
	
	
}
