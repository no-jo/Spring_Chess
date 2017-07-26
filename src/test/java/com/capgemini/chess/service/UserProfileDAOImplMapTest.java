package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.ecxeptions.NoDataToRead;
import com.capgemini.chess.profileDAOimpl.PlayerProfileDAOImplMap;
import com.capgemini.chess.service.to.UserProfileTO;

public class UserProfileDAOImplMapTest {
	// TODO pytanie: jaka praktyka jest lepsza czy polegac na junitcie czy pisac
	// to samemu w kazdym tescie ?
	PlayerProfileDAOImplMap DAO = new PlayerProfileDAOImplMap();
	UserProfileTO profile1 = new UserProfileTO();
	UserProfileTO profile2 = new UserProfileTO();

	@Before
	public void setUp() throws Exception {
		addProfileDetailsSample1();
		addProfileDetailsSample2();
	}

	@Test
	public void shouldStoreNewProfileWithID1() throws NoDataToRead {
		// when
		DAO.create(profile1);
		Long result = 1L;
		UserProfileTO read = DAO.read(profile1.getId());
		// then
		assertEquals(1, DAO.getProfiles().size());
		assertTrue(DAO.getProfiles().containsKey(1L));
		assertEquals(result, read.getId());
	}

	@Test
	public void shouldStoreTwoUsersAndDeleteFirstOne() {
		// when
		UserProfileTO firstProfile = DAO.create(profile1);
		UserProfileTO secondProfile = DAO.create(profile2);
		DAO.delete(firstProfile.getId());
		Long result = 2L;
		// then
		assertEquals(1, DAO.getProfiles().size());
		assertTrue(DAO.getProfiles().containsKey(2L));
		assertEquals(result, secondProfile.getId());
	}
	
	@Test
	public void shouldUpdateUser() {
		// given
		DAO.create(profile1);
		DAO.create(profile2);
		UserProfileTO thirdProfile = new UserProfileTO();
		thirdProfile.setName("Anna");
		thirdProfile.setId(profile1.getId());
		
		//when
		thirdProfile = DAO.update(thirdProfile);

		// then
		assertEquals(2, DAO.getProfiles().size());
		UserEntity user_name = DAO.getProfiles().get(1L);
		assertEquals("Anna", user_name.getName());

	}
	
	private void addProfileDetailsSample2() {
		profile2.setAboutMe("Etwas");
		profile2.setEmail("email@gut.de");
		profile2.setLifeMotto("gute reise");
		profile2.setName("Hans");
		profile2.setSurname("Holaus");
	}

	private void addProfileDetailsSample1() {
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
	}
}
