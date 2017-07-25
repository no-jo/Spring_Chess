package com.capgemini.chess.profileDAO;

import com.capgemini.chess.service.to.UserProfileTO;

public interface UserProfileDAO {
	
	UserProfileTO create(UserProfileTO newProfile);
	UserProfileTO read(Long userID);	
	UserProfileTO update(UserProfileTO newProfile);
	UserProfileTO delete(Long userID);
	
}
