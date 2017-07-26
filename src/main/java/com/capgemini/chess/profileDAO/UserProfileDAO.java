package com.capgemini.chess.profileDAO;

import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.service.to.AccountTO;
import com.capgemini.chess.service.to.UserProfileTO;

public interface UserProfileDAO {
	
	AccountTO create(AccountTO newProfile);
	UserProfileTO readProfile(Long userID) throws UserNotFound;	
	UserProfileTO update(UserProfileTO newProfile);
	AccountTO update(AccountTO newAccountTO);
	UserProfileTO delete(Long userID);
	UserProfileTO findByEmail(String email);
	AccountTO readAccount(Long userID) throws UserNotFound;
	
}
