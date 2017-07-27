package com.capgemini.chess.profileDAOimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.mapper.AccountMapper;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.AccountTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Repository
public class UserProfileDAOImplMap implements UserProfileDAO {

	private Map<Long, UserEntity> profiles = new HashMap<Long, UserEntity>();
	
	public void addEntity(UserEntity newUser) {
//		Long key = generateId();
//		newUser.setId(key);
		profiles.put(newUser.getId(), newUser);
		return;
	}

	@Override
	public AccountTO create(AccountTO newProfile) {
		Long key = generateId();
		newProfile.setId(key);
		profiles.put(key, AccountMapper.map(newProfile));
		return newProfile;
	}

	@Override
	public UserProfileTO readProfile(Long userID) throws UserNotFound {
		UserEntity user = profiles.get(userID);
		if (user == null) {
			throw new UserNotFound();
		}
		return UserProfileMapper.map(user);
	}
	
	@Override
	public AccountTO readAccount(Long userID) throws UserNotFound {
		UserEntity user = profiles.get(userID);
		if (user == null) {
			throw new UserNotFound();
		}
		return AccountMapper.map(user);
	}

	@Override
	public UserProfileTO update(UserProfileTO newProfile) {
		UserEntity currentUser = profiles.get(newProfile.getId());
		UserEntity newUser = UserProfileMapper.map(newProfile);
		newUser.setLogin(currentUser.getLogin());
		newUser.setPassword(currentUser.getPassword());
		profiles.put(newUser.getId(), newUser);
		return newProfile;
	}

	@Override
	public AccountTO update(AccountTO newAccountTO) {
//		AccountTO storedTO = new AccountTO(AccountMapper.map(profiles.get(newAccountTO.getId())));
//		TODO could this be used or is there a better way? remember to delete copy contructor if not used
//		Field[] fields = newAccountTO.getClass().getDeclaredFields();
//		for(Field f : fields){
//				storedTO = f;
//		}
		//obcnie w tym scenariuszu wszystko przesylamy
		UserEntity currentUser = profiles.get(newAccountTO.getId());
		UserEntity newUser = AccountMapper.map(newAccountTO);
		currentUser.setLogin(newUser.getLogin());
		currentUser.setPassword(newUser.getPassword());
		profiles.put(newAccountTO.getId(), currentUser);
		return newAccountTO;
	}

	@Override
	public UserProfileTO delete(Long userID) {
		return UserProfileMapper.map(profiles.remove(userID));
	}

	@Override
	public UserProfileTO findByEmail(String email) {
		UserEntity user = profiles.values().stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
		return UserProfileMapper.map(user);
	}

	private Long generateId() {
		return profiles.keySet().stream().max((i1, i2) -> i1.compareTo(i2)).orElse(0L) + 1;
	}

	public Map<Long, UserEntity> getProfiles() {
		return profiles;
	}
}
