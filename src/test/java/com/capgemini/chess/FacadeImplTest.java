package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.Facade;
import com.capgemini.chess.FacadeImpl;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.objects.UserProfileDAO;
import com.capgemini.chess.dataaccess.objects.UserProfileDAOImplMap;
import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.service.AccountService;
import com.capgemini.chess.service.EmailValidationService;
import com.capgemini.chess.service.PasswordValidator;
import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.impl.AccountServiceImpl;
import com.capgemini.chess.service.impl.EmailValidationServiceImpl;
import com.capgemini.chess.service.impl.PasswordValidatorImpl;
import com.capgemini.chess.service.impl.ProfileServiceImpl;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FacadeImplTest {
	
	@Autowired
	Facade facade;
	@Autowired
	UserProfileDAO dao;
	@Autowired
	EmailValidationService emailService;
	@Autowired
	ProfileService service;
	@Autowired
	PasswordValidator passval;
	@Autowired
	AccountService accserv;
	
	@Configuration
	static class RankServiceTestContextConfiguration {
		@Bean
		public Facade Facade() {
			return new FacadeImpl();
		}
		@Bean
		public UserProfileDAO UserProfileDAO() {
			return new UserProfileDAOImplMap();
		}
		@Bean
		public EmailValidationService EmailValidationService() {
			return new EmailValidationServiceImpl(UserProfileDAO());
		}
		@Bean
		public ProfileService ProfileService() {
			return new ProfileServiceImpl();
		}
		@Bean
		public PasswordValidator PasswordValidator() {
			return new PasswordValidatorImpl();
		}
		
		@Bean
		public AccountService AccountService() {
			return new AccountServiceImpl();
		}
	}

	@Before
	public void addTestData() {
		addUserEntities();
	}

	@Test
	public void shouldSuccesfullyUpdateEmail() throws EmailAlreadyExists, UserNotFound {
		//when
		UserProfileTO newProfile = new UserProfileTO();
		newProfile.setId(3L);
		newProfile.setEmail("new@email.com");
		facade.updateProfile(newProfile);
		
		//then
		assertEquals("new@email.com", dao.readProfile(3L).getEmail());
	}
	
	@Test (expected = EmailAlreadyExists.class)
	public void shouldThrowExceptionForDuplicatedEmail() throws EmailAlreadyExists, UserNotFound {
		//when
		UserProfileTO newProfile = new UserProfileTO();
		newProfile.setId(3L);
		newProfile.setEmail("email@gut.de");
		facade.updateProfile(newProfile);
		
		//then
		fail("Exception was not thrown");
	}

	@Test (expected = InvalidPassword.class)
	public void shouldThrowExceptionPasswordNotValid() throws InvalidPassword {
		//when
		facade.changePassword(new AccountTO(10L, "sample_log", "pass"));
		//then
		fail("Password not validated correctly");
	}
	
	@Test 
	public void shouldUpdatePasswordCorrectly() throws InvalidPassword, UserNotFound {
		//when
		facade.changePassword(new AccountTO(10L, "sample", "PASS"));
		//then
		assertEquals("PASS", dao.readAccount(10L).getPassword());
	}

	@Test
	@Ignore
	public void testGetStats() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testUpdateRanking() {
		fail("Not yet implemented");
	}
	
	private void addUserEntities() {
		UserEntity profile2 = new UserEntity();
		profile2.setAboutMe("Etwas");
		profile2.setEmail("email@gut.de");
		profile2.setLifeMotto("gute reise");
		profile2.setName("Hans");
		profile2.setSurname("Holaus");
		profile2.setPassword("AAA");
		profile2.setLogin("dinge");
		profile2.setId(3L);
		dao.addEntity(profile2);

		UserEntity profile1 = new UserEntity();
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
		profile1.setPassword("VVV");
		profile1.setLogin("sth");
		profile1.setId(5L);
		dao.addEntity(profile1);
		
		UserEntity profile3 = new UserEntity();
		profile3.setAboutMe("About");
		profile3.setEmail("email@tocheck.pl");
		profile3.setLifeMotto("per aspera");
		profile3.setName("Mick");
		profile3.setSurname("Pooh");
		profile3.setPassword("ASWN");
		profile3.setLogin("sample");
		profile3.setId(10L);
		dao.addEntity(profile3);
		
	}

}
