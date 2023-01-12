package hopital.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthDTO {
	@JsonProperty("mail")
	private String mail;
	@JsonProperty("password")
	private String password;
	public AuthDTO() {
		super();
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
	
	
	
	}
	
	
	
