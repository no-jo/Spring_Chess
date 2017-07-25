package com.capgemini.chess.profileDAOimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.ecxeptions.NoDataToRead;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Repository
public class PlayerProfileDAOImplMap implements UserProfileDAO {

	private Map<Long, UserEntity> profiles = new HashMap<Long, UserEntity>();

	@Override
	public UserProfileTO create(UserProfileTO newProfile) {
		Long key = generateId();
		newProfile.setId(key);
		profiles.put(key, UserProfileMapper.map(newProfile));
		return newProfile;
	}

	@Override
	public UserProfileTO read(Long userID) throws NoDataToRead {
		if (profiles.isEmpty()) {
			throw new NoDataToRead();
		}
		return UserProfileMapper.map(profiles.get(userID));
	}

	@Override
	public UserProfileTO update(UserProfileTO newProfile) {
		profiles.put(newProfile.getId(), UserProfileMapper.map(newProfile));
		return newProfile;
	}

	@Override
	public UserProfileTO delete(Long userID) {
		return UserProfileMapper.map(profiles.remove(userID));
		//TODO co powinna zwracac metod delete, void lub wczesniej ususniety obiekt, jak w kolekcji
	}

	private Long generateId() {
		return profiles.keySet().stream().max((i1, i2) -> i1.compareTo(i2)).orElse(0L) + 1;
	}

	public Map<Long, UserEntity> getProfiles() {
		return profiles;
	}

	public void setProfiles(Map<Long, UserEntity> profiles) {
		this.profiles = profiles;
	}

}
