package com.capgemini.chess.service;

import com.capgemini.chess.exceptions.EmailAlreadyExists;

public interface EmailValidationService {

	 void validateEmail(String email) throws EmailAlreadyExists;
}
