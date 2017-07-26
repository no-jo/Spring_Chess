package com.capgemini.chess.service;

import com.capgemini.chess.ecxeptions.InvalidPassword;
import com.capgemini.chess.service.to.AccountTO;

public interface AccountService {
	
	AccountTO changePassword(AccountTO newTO) throws InvalidPassword;

}
