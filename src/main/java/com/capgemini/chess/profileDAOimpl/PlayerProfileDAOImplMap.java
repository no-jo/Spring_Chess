package com.capgemini.chess.profileDAOimpl;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

public class PlayerProfileDAOImplMap implements UserProfileDAO {
	
	private Map<Long, UserEntity> profiles = new HashMap<Long, UserEntity>();

	@Override
	public UserProfileTO create(UserProfileTO newProfile) {
		if (profiles.containsKey(newProfile.getId())) 
			throw new RuntimeException();
		profiles.put(newProfile.getId(), UserProfileMapper.map(newProfile));
		return null;
	}

	@Override
	public UserProfileTO read(Long userID) {
		return UserProfileMapper.map(profiles.get(userID));
	}

	@Override
	public UserProfileTO update(UserProfileTO newProfile) {
		profiles.put(newProfile.getId(), UserProfileMapper.map(newProfile));
		return null;
	}

	@Override
	public UserProfileTO delete(Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
