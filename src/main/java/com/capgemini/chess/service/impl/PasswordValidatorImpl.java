package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.service.PasswordValidator;

@Service
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
