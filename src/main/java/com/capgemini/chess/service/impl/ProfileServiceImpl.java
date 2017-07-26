package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.ecxeptions.EmailAlreadyExists;
import com.capgemini.chess.ecxeptions.NoDataToRead;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.EmailValidationService;
import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private UserProfileDAO profileDao;
	@Autowired
	private EmailValidationService emailValidation;

	@Override
	public UserProfileTO readUser(Long id) throws NoDataToRead {
		return profileDao.read(id);
	}

	@Override
	public UserProfileTO update(UserProfileTO user) throws EmailAlreadyExists {
		emailValidation.validateEmail(user.getEmail());
		return profileDao.update(user);
	}
	
}
