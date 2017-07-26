package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class AccountEntity {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
