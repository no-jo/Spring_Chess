package com.capgemini.chess.service;

import com.capgemini.chess.ecxeptions.EmailAlreadyExists;

public interface EmailValidationService {

	 void validateEmail(String email) throws EmailAlreadyExists;
}
