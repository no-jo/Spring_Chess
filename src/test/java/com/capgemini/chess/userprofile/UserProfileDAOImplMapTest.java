package com.capgemini.chess.userprofile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.objects.UserProfileDAOImplMap;
import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

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
		AccountTO profile = new AccountTO();
		profile.setPassword("VVV");
		profile.setLogin("sth");
		Long result = 1L;
		
		//when
		userDAO.create(profile);
		AccountTO read = userDAO.readAccount(profile.getId());
		
		// then
		assertEquals(1, userDAO.getProfiles().size());
		assertTrue(userDAO.getProfiles().containsKey(1L));
		assertEquals(result, read.getId());
	}

	@Test
	public void shouldStoreTwoUsersAndDeleteFirstOne() {
		// when
		DAO.delete(333L);
		// then
		assertEquals(1, DAO.getProfiles().size());
		assertTrue(DAO.getProfiles().containsKey(500L));
	}

	@Test
	public void shouldUpdateUserProfile() {
		// given
		UserProfileTO updatedProfile = new UserProfileTO(UserProfileMapper.map(DAO.getProfiles().get(333L)));
		updatedProfile.setName("Anna");

		// when
		updatedProfile = DAO.update(updatedProfile);

		// then
		assertEquals(2, DAO.getProfiles().size());
		assertEquals("Anna", DAO.getProfiles().get(333L).getName());
		assertEquals("Holaus", DAO.getProfiles().get(333L).getSurname());
	}
	
	@Test
	public void shouldUpdatePassword() {
		// given
		AccountTO updatedAccount = new AccountTO();
		updatedAccount.setPassword("Anna");
		updatedAccount.setId(500L);

		// when
		updatedAccount = DAO.update(updatedAccount);

		// then
		assertEquals(2, DAO.getProfiles().size());
		assertEquals("Anna", DAO.getProfiles().get(500L).getPassword());
		assertEquals("Smith", DAO.getProfiles().get(500L).getSurname());
	}
	
	@Test
	public void shouldFindByEmail() {
		//given
		String email = "email@gut.de";
		
		//when
		UserProfileTO profile = DAO.findByEmail(email);
		
		//then
		assertTrue(null != profile);
	}
	
	@Test
	public void shouldFindByEmailReturnNull() {
		//given
		String email = "a";
		
		//when
		UserProfileTO profile = DAO.findByEmail(email);
		
		//then
		assertTrue(null == profile);
	}
	
	@Test (expected = UserNotFound.class)
	public void shouldThrowNotFoundWhenNoProfile() throws UserNotFound {
		//when
		DAO.readProfile(2L);
		//
		fail("User not found exception not thrown");
	}
	
	@Test (expected = UserNotFound.class)
	public void shouldThrowNotFoundWhenNoAccount() throws UserNotFound {
		//when
		DAO.readAccount(2L);
		//
		fail("User not found exception not thrown");
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