package com.capgemini.chess.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ecxeptions.NoDataToRead;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.profileDAOimpl.PlayerProfileDAOImplMap;
import com.capgemini.chess.service.impl.ProfileServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {

	@Autowired
	ProfileService service;
	UserProfileDAO dao;

	@Configuration
	static class RankServiceTestContextConfiguration {
		@Bean
		public ProfileService userService() {
			return new ProfileServiceImpl();
		}
		@Bean
		public UserProfileDAO daoSetup() {
			return new PlayerProfileDAOImplMap();
		}
	}
	

	@Test (expected = NoDataToRead.class)
	public void shouldThrowExceptionAsDataIsEmpty() throws Exception {

		// when
		service.readUser(1L);
		
		// then exception
	}

}
