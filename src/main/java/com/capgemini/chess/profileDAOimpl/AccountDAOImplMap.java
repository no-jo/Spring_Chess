package com.capgemini.chess.profileDAOimpl;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.chess.dataaccess.entities.AccountEntity;
import com.capgemini.chess.profileDAO.AccountDAO;
import com.capgemini.chess.service.mapper.AccountMapper;
import com.capgemini.chess.service.to.AccountTO;

public class AccountDAOImplMap implements AccountDAO {
	
	private Map<Long, AccountEntity> users = new HashMap<Long, AccountEntity>();

	@Override
	public AccountTO create(AccountTO newAccount) {
		users.put(newAccount.getId(), AccountMapper.map(newAccount));
		return newAccount;
	}

	@Override
	public AccountTO update(AccountTO newAccount) {
		users.put(newAccount.getId(), AccountMapper.map(newAccount));
		return newAccount;
	}

	@Override
	public AccountTO findByID(Long id) {
		return AccountMapper.map(users.get(id));
	}

}
