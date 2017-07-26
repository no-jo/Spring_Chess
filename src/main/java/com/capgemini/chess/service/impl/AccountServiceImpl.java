package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.ecxeptions.InvalidPassword;
import com.capgemini.chess.profileDAO.AccountDAO;
import com.capgemini.chess.service.AccountService;
import com.capgemini.chess.service.PasswordValidator;
import com.capgemini.chess.service.to.AccountTO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	PasswordValidator passValidation;
	@Autowired
	AccountDAO accountDao;
	
	@Override
	public AccountTO changePassword(AccountTO newTO) throws InvalidPassword {
		passValidation.validatePassword(newTO.getPassword());
		return accountDao.update(newTO);
	}

}
