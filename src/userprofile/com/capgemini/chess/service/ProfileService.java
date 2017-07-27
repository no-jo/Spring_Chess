package com.capgemini.chess.service;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.tos.UserProfileTO;

public interface ProfileService {
	
	public UserProfileTO readUser(Long id) throws UserNotFound;
	
	public UserProfileTO update(UserProfileTO user) throws EmailAlreadyExists;
	
}
