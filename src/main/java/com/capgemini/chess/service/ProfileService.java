package com.capgemini.chess.service;

import com.capgemini.chess.ecxeptions.EmailAlreadyExists;
import com.capgemini.chess.ecxeptions.NoDataToRead;
import com.capgemini.chess.service.to.UserProfileTO;

public interface ProfileService {
	
	public UserProfileTO readUser(Long id) throws NoDataToRead;
	
	public UserProfileTO update(UserProfileTO user) throws EmailAlreadyExists;
	
}
