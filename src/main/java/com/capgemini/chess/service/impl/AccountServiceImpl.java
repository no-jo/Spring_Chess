package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.AccountService;
import com.capgemini.chess.service.PasswordValidator;
import com.capgemini.chess.service.to.AccountTO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	PasswordValidator passValidation;
	@Autowired
	UserProfileDAO userDao;
	
	@Override
	public AccountTO changePassword(AccountTO newAccountTO) throws InvalidPassword {
		passValidation.validatePassword(newAccountTO.getPassword());
		return userDao.update(newAccountTO);
	}

	public void setPassValidation(PasswordValidator passValidation) {
		this.passValidation = passValidation;
	}

	public void setUserDao(UserProfileDAO userDao) {
		this.userDao = userDao;
	}

}
