package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;

public interface ProfileService {
	
	public UserProfileTO readUser(Long id);
	
	public UserProfileTO update(UserProfileTO user);
	
}
