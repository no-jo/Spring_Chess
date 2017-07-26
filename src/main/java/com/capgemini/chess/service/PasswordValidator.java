package com.capgemini.chess.service;

import com.capgemini.chess.exceptions.InvalidPassword;

public interface PasswordValidator {
	
	void validatePassword(String password) throws InvalidPassword;
	
}
