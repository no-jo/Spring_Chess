package com.capgemini.chess.dataaccess.objects;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.mapper.AccountMapper;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

@Repository
public class UserProfileDAOImplMap implements UserProfileDAO {

	private Map<Long, UserEntity> profiles = new HashMap<Long, UserEntity>();
	
	public UserProfileDAOImplMap () {
		UserEntity profile2 = new UserEntity();
		profile2.setAboutMe("Etwas");
		profile2.setEmail("email@gut.de");
		profile2.setLifeMotto("gute reise");
		profile2.setName("Hans");
		profile2.setSurname("Holaus");
		profile2.setPassword("AAA");
		profile2.setLogin("dinge");
		profile2.setId(333L);
		profiles.put(333L, profile2);

		UserEntity profile1 = new UserEntity();
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
		profile1.setPassword("VVV");
		profile1.setLogin("sth");
		profile1.setId(500L);
		profiles.put(500L, profile1);
	}
	
	public void addEntity(UserEntity newUser) {
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
	public UserProfileTO readProfile(Long userID) throws UserNotFoundException {
		UserEntity user = profiles.get(userID);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return UserProfileMapper.map(user);
	}
	
	@Override
	public AccountTO readAccount(Long userID) throws UserNotFoundException {
		UserEntity user = profiles.get(userID);
		if (user == null) {
			throw new UserNotFoundException();
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
		UserEntity user = profiles.values().stream()
				.filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
		return UserProfileMapper.map(user);
	}

	private Long generateId() {
		return profiles.keySet().stream().max((i1, i2) -> i1.compareTo(i2)).orElse(0L) + 1;
	}

	public Map<Long, UserEntity> getProfiles() {
		return profiles;
	}
}
