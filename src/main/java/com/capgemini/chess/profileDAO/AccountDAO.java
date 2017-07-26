package com.capgemini.chess.profileDAO;

import com.capgemini.chess.service.to.AccountTO;

public interface AccountDAO {

	AccountTO create(AccountTO newAccount);	
	AccountTO update(AccountTO newAccount);
	AccountTO findByID(Long id);
	
}
