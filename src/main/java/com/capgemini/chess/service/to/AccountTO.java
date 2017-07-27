package com.capgemini.chess.service.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountTO {

	private Long id;
	private String login;
	private String password;
	
	public AccountTO(AccountTO accountTO) {
		this.id = accountTO.getId();
		this.login = accountTO.getLogin();
		this.password = accountTO.getPassword();
	}
	
	public AccountTO(Long ID, String log, String pass) {
		id = ID;
		login = log;
		password = pass;
	}
	public AccountTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
}
