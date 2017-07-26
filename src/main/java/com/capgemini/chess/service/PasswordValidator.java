package com.capgemini.chess.service;

import com.capgemini.chess.ecxeptions.InvalidPassword;

public interface PasswordValidator {
	
	void validatePassword(String password) throws InvalidPassword;
	
}
