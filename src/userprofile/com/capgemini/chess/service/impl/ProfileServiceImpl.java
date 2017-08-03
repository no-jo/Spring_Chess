package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.objects.UserProfileDAO;
import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.EmailValidationService;
import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.tos.UserProfileTO;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private UserProfileDAO profileDao;
	@Autowired
	private EmailValidationService emailValidation;

	@Override
	public UserProfileTO readUser(Long id) throws UserNotFoundException {
		return profileDao.readProfile(id);
	}

	@Override
	public UserProfileTO update(UserProfileTO user) throws EmailAlreadyExists {
		emailValidation.validateEmail(user.getEmail());
		return profileDao.update(user);
	}

	public void setProfileDao(UserProfileDAO profileDao) {
		this.profileDao = profileDao;
	}

	public void setEmailValidation(EmailValidationService emailValidation) {
		this.emailValidation = emailValidation;
	}
	
}
