package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.profileDAOimpl.PlayerProfileDAOImplMap;
import com.capgemini.chess.service.to.UserProfileTO;

public class UserProfileDAOImplMapTest {
//TODO dlaczego testy dzialaja? czemu kazda metoda ma nowa instancje mapy
	PlayerProfileDAOImplMap DAO = new PlayerProfileDAOImplMap();
	UserProfileTO profile1 = new UserProfileTO();
	UserProfileTO profile2 = new UserProfileTO();
	
	@Before
	public void setUp() throws Exception {
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setLogin("login");
		profile1.setName("Mark");
		profile1.setPassword("hash#");
		profile1.setSurname("Smith");
		

		profile2.setAboutMe("Etwas");
		profile2.setEmail("email@gut.de");
		profile2.setLifeMotto("gute reise");
		profile2.setLogin("benutzer");
		profile2.setName("Hans");
		profile2.setPassword("schatz!!");
		profile2.setSurname("Holaus");
	}

	@Test
	public void shouldStoreNewProfileWithID1() {
		//when
		UserProfileTO profile = DAO.create(profile1);
		Long result = 1L;
		//then
		assertEquals(1,DAO.getProfiles().size());
		assertTrue(DAO.getProfiles().containsKey(1L));	
		assertEquals(result, profile.getId());
	}
	
	@Test
	public void shouldStoreTwoUsers() {
		//when
		UserProfileTO firstProfile = DAO.create(profile1);
		UserProfileTO secondProfile = DAO.create(profile2);
		Long result = 2L;
		//then
		assertEquals(2,DAO.getProfiles().size());
		assertTrue(DAO.getProfiles().containsKey(2L));
		assertEquals(result, secondProfile.getId());
	}
	
	@Test
	public void shouldUpdateUser() {
		//when
		UserProfileTO firstProfile = DAO.create(profile1);
		UserProfileTO secondProfile = DAO.create(profile2);
		profile1.setName("Jerry");
		UserProfileTO thirdProfile = DAO.update(profile1);
		
		UserEntity user_name = DAO.getProfiles().get(profile1.getId());
		
		//then
		assertEquals(2,DAO.getProfiles().size());
		assertTrue(DAO.getProfiles().containsKey(2L));
		assertEquals("Jerry", user_name.getName());

	}

}
