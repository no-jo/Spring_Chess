package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	private UserProfileDAO profileDao;

	@Override
	public UserProfileTO readUser(Long id) {
		return profileDao.read(id);
	}

	@Override
	public UserProfileTO update(UserProfileTO user) {
		return profileDao.update(user);
	}
}
