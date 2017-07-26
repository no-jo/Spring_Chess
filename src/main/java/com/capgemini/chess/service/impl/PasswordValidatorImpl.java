package com.capgemini.chess.service.impl;

import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.service.PasswordValidator;

public class PasswordValidatorImpl implements PasswordValidator {

	@Override
	public void validatePassword(String password) throws InvalidPassword {
		if (password.matches("[A-Z]+")) {
			return;
		} else {
			throw new InvalidPassword();
		}
	}

}
