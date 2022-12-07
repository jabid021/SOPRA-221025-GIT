package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//Obligatoire
@Entity
@Table(name="wizard", uniqueConstraints=@UniqueConstraint(columnNames = { "nom","firstname"}) )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_sorcier",columnDefinition = "ENUM('teacher','student')")
public abstract class Sorcier {
	
	//Obligatoire
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(columnDefinition = "VARCHAR(35)")
	protected String nom;
	
	@Column(name="firstname",nullable=false,length = 35)
	protected String prenom;
	
	@Embedded
	protected Stats statistiques;
	
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="animal",nullable = false,columnDefinition = "ENUM('Cerf','Coccinelle','Loutre','Chien','Phoenix')")
	private Patronus patronus;
	
	
/*	@JoinTable(
			name="competence",
			joinColumns = @JoinColumn(name="sorcier"),
			inverseJoinColumns = @JoinColumn(name="sort"),
			uniqueConstraints=@UniqueConstraint(columnNames = { "sorcier","sort"})
			)
	@ManyToMany
	private List<Sort> sorts=new ArrayList();
	*/
	
	@JoinColumn(name="baguette")
	@OneToOne
	private Baguette baguette;
	
	
	//Obligatoire
	public Sorcier() {}


	public Sorcier(String nom, String prenom,Patronus patronus,Stats statistiques) {
		this.nom = nom;
		this.prenom = prenom;
		this.patronus=patronus;
		this.statistiques=statistiques;
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
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	
	public Patronus getPatronus() {
		return patronus;
	}


	public void setPatronus(Patronus patronus) {
		this.patronus = patronus;
	}
	



	public Stats getStatistiques() {
		return statistiques;
	}


	public void setStatistiques(Stats statistiques) {
		this.statistiques = statistiques;
	}


	/*public List<Sort> getSorts() {
		return sorts;
	}


	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}
*/

	public Baguette getBaguette() {
		return baguette;
	}


	public void setBaguette(Baguette baguette) {
		this.baguette = baguette;
	}


	

	




}
