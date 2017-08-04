package com.capgemini.chess.service;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.tos.UserProfileTO;

public interface ProfileService {
	
	public UserProfileTO readUser(Long id) throws UserNotFoundException;
	
	public UserProfileTO update(UserProfileTO user) throws EmailAlreadyExists;

	public UserProfileTO delete(Long id);
	
}
