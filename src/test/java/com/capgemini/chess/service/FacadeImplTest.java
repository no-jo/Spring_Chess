package com.capgemini.chess.service;

import static org.junit.Assert.fail;

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
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.profileDAOimpl.UserProfileDAOImplMap;
import com.capgemini.chess.service.impl.AccountServiceImpl;
import com.capgemini.chess.service.impl.EmailValidationServiceImpl;
import com.capgemini.chess.service.impl.PasswordValidatorImpl;
import com.capgemini.chess.service.impl.ProfileServiceImpl;
import com.capgemini.chess.service.to.AccountTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FacadeImplTest {
	
	@Autowired
	Facade facade;
	@Autowired
	static 	UserProfileDAO dao;
	@Autowired
	EmailValidationService emailService;
	@Autowired
	ProfileService service;
	@Autowired
	PasswordValidator passval;
	@Autowired
	AccountService accserv;
	
	@Configuration //TODO (classes = {????.class})
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
			return new EmailValidationServiceImpl(dao);
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

	@Test
	@Ignore
	public void testUpdateProfile() {
		fail("Not yet implemented");
	}

	@Test (expected = InvalidPassword.class)
	public void shouldThrowExceptionPasswordNotValid() throws InvalidPassword {
		//when
		facade.changePassword(new AccountTO(4L, "sample_log", "pass"));
		//then
		fail("Password not validated correctly");
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

}
