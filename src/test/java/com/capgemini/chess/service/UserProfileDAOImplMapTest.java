package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.profileDAOimpl.UserProfileDAOImplMap;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.AccountTO;
import com.capgemini.chess.service.to.UserProfileTO;

public class UserProfileDAOImplMapTest {

	UserProfileDAOImplMap DAO;
	UserProfileTO profile1;
	UserProfileTO profile2;

	@Before
	public void setUp() throws Exception {
		DAO = new UserProfileDAOImplMap();
		addInitialEntitiesToMap(DAO);
	}

	@Test
	public void shouldStoreNewProfileWithID1() throws UserNotFound {
		// given
		UserProfileDAOImplMap userDAO = new UserProfileDAOImplMap();		
		AccountTO profile1 = new AccountTO();
		profile1.setPassword("VVV");
		profile1.setLogin("sth");
		Long result = 1L;
		
		//when
		userDAO.create(profile1);
		AccountTO read = DAO.readAccount(profile1.getId());
		
		// then
		assertEquals(1, userDAO.getProfiles().size());
		assertTrue(userDAO.getProfiles().containsKey(1L));
		assertEquals(result, read.getId());
	}

	@Test
	public void shouldStoreTwoUsersAndDeleteFirstOne() {
		// when
		DAO.delete(1L);
		// then
		assertEquals(1, DAO.getProfiles().size());
		assertTrue(DAO.getProfiles().containsKey(2L));
	}

	@Test
	public void shouldUpdateUserProfile() {
		// given
		UserProfileTO thirdProfile = new UserProfileTO(UserProfileMapper.map(DAO.getProfiles().get(333L)));
		thirdProfile.setName("Anna");

		// when
		thirdProfile = DAO.update(thirdProfile);

		// then
		assertEquals(2, DAO.getProfiles().size());
		assertEquals("Anna", DAO.getProfiles().get(333L).getName());
	}
	
	@Test
	public void shouldUpdatePassword() {
		// given
		AccountTO thirdProfile = new AccountTO();
		thirdProfile.setPassword("Anna");
		thirdProfile.setId(500L);

		// when
		thirdProfile = DAO.update(thirdProfile);

		// then
		assertEquals(2, DAO.getProfiles().size());
		assertEquals("Anna", DAO.getProfiles().get(500L).getPassword());
	}

	private void addInitialEntitiesToMap(UserProfileDAOImplMap dAO2) {

		UserEntity profile2 = new UserEntity();
		profile2.setAboutMe("Etwas");
		profile2.setEmail("email@gut.de");
		profile2.setLifeMotto("gute reise");
		profile2.setName("Hans");
		profile2.setSurname("Holaus");
		profile2.setPassword("AAA");
		profile2.setLogin("dinge");
		profile2.setId(333L);
		DAO.addEntity(profile2);

		UserEntity profile1 = new UserEntity();
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
		profile1.setPassword("VVV");
		profile1.setLogin("sth");
		profile1.setId(500L);
		DAO.addEntity(profile1);
	}
}