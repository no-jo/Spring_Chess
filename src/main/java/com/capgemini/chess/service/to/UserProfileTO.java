package com.capgemini.chess.service.to;

public class UserProfileTO {
	
	private Long id;
	private String name;
	private String surname;
	private String email;
	private String aboutMe;
	private String lifeMotto;

	public UserProfileTO () {};
	
	public UserProfileTO (UserProfileTO profile) {
		  this.id = profile.getId();
		  this.name = profile.getName();
		  this.surname = profile.getSurname();
		  this.email = profile.getEmail();
		  this.aboutMe = profile.getAboutMe();
		  this.lifeMotto = profile.getLifeMotto();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}
	
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	public String getLifeMotto() {
		return lifeMotto;
	}
	
	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}
}
