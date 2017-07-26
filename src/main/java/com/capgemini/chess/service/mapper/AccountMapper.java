package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.AccountTO;

public class AccountMapper {

	public static AccountTO map(UserEntity accountEntity) {
		if (accountEntity != null) {
			AccountTO accountTO = new AccountTO();
			accountTO.setId(accountEntity.getId());
			accountTO.setLogin(accountEntity.getLogin());
			accountTO.setPassword(accountEntity.getPassword());
			return accountTO;
		}
		return null;
	}

	public static UserEntity map(AccountTO accountTO) {
		if (accountTO != null) {
			UserEntity accountEntity = new UserEntity();
			accountEntity.setId(accountTO.getId());
			accountEntity.setLogin(accountTO.getLogin());
			accountEntity.setPassword(accountTO.getPassword());
			return accountEntity;
		}
		return null;
	}
	

	public static List<AccountTO> map2TOs(List<UserEntity> userEntities) {
		return userEntities.stream().map(AccountMapper::map).collect(Collectors.toList());
	}

	public static List<UserEntity> map2Entities(List<AccountTO> userTOs) {
		return userTOs.stream().map(AccountMapper::map).collect(Collectors.toList());
	}
}
