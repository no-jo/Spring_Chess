package com.capgemini.chess.dataaccess.objects;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

public interface UserProfileDAO {	

	AccountTO create(AccountTO newProfile);
	AccountTO update(AccountTO newAccountTO);
	AccountTO readAccount(Long userID) throws UserNotFoundException;
	UserProfileTO readProfile(Long userID) throws UserNotFoundException;	
	UserProfileTO update(UserProfileTO newProfile);
	UserProfileTO delete(Long userID);
	UserProfileTO findByEmail(String email);
	void addEntity(UserEntity newUser);
	
}
