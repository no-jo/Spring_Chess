package com.capgemini.chess.profileDAO;

import com.capgemini.chess.ecxeptions.NoDataToRead;
import com.capgemini.chess.service.to.UserProfileTO;

public interface UserProfileDAO {
	
	UserProfileTO create(UserProfileTO newProfile);
	UserProfileTO read(Long userID) throws NoDataToRead;	
	UserProfileTO update(UserProfileTO newProfile);
	UserProfileTO delete(Long userID);
	
}
