package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.ecxeptions.EmailAlreadyExists;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.EmailValidationService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class EmailValidationServiceImpl implements EmailValidationService {

	@Autowired
	private UserProfileDAO profileDao;
	
	@Override
	public void validateEmail(String email) throws EmailAlreadyExists {
		UserProfileTO profile = profileDao.findByEmail(email);
		if (profile == null) {
			return;
		} else {
			throw new EmailAlreadyExists();
		}
	}

}
