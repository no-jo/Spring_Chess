package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.objects.UserProfileDAO;
import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.service.EmailValidationService;

@Service
public class EmailValidationServiceImpl implements EmailValidationService {

	private UserProfileDAO profileDao = null;
	
	@Autowired
	public EmailValidationServiceImpl(UserProfileDAO profile) {
		profileDao = profile;
	};
	
	@Override
	public void validateEmail(String email) throws EmailAlreadyExists {
		if (null == profileDao.findByEmail(email)) {
			return;
		} else {
			throw new EmailAlreadyExists();
		}
	}

}
