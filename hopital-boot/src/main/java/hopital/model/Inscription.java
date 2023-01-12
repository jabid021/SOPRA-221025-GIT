package hopital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="inscription")
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private String login;
	@JsonView(Views.ViewBase.class)
	private Integer mdp;
	@JsonView(Views.ViewBase.class)
	private String choix;
	
	public Inscription() {
	}
	
	
	/**
	 * @param id
	 * @param login
	 * @param mdp
	 */
	public Inscription(Integer id, String login, Integer mdp, String choix) {
		super();
		this.id = id;
		this.login = login;
		this.choix = choix;
		this.mdp = mdp;
	}


	public String getLogin() {
		return login;
	}


	public Integer getMdp() {
		return mdp;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setMdp(Integer mdp) {
		this.mdp = mdp;
	}


	public String getChoix() {
		return choix;
	}


	public void setChoix(String choix) {
		this.choix = choix;
	}


	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}