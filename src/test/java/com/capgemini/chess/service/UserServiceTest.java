package com.capgemini.chess.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.profileDAOimpl.UserProfileDAOImplMap;
import com.capgemini.chess.service.impl.EmailValidationServiceImpl;
import com.capgemini.chess.service.impl.ProfileServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {

	@Autowired
	ProfileService service;
	@Autowired
	UserProfileDAO dao;
	@Autowired
	EmailValidationService emailService;
	
	@Configuration //TODO (classes = {????.class})
	static class RankServiceTestContextConfiguration {
		@Bean
		public ProfileService userService() {
			return new ProfileServiceImpl();
		}
		@Bean
		public UserProfileDAO daoSetup() {
			return new UserProfileDAOImplMap();
		}
	}
	

	@Test (expected = UserNotFound.class)
	public void shouldThrowExceptionAsDataIsEmpty() throws Exception {

		// when
		service.readUser(1L);
		
		// then exception
	}

}
