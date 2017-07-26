package com.capgemini.chess.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.profileDAOimpl.PlayerProfileDAOImplMap;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmailValidationServiceImpl {

		@Autowired
		UserProfileDAO profileDao;

		@Configuration
		static class RankServiceTestContextConfiguration {
			@Bean
			public UserProfileDAO profileService() {
				return new PlayerProfileDAOImplMap();
			}
		}

		@Test
		public void FailTest() {
			fail();
			
			// TODO odpowiednik
			//when(profileDao.findByEmail("a").thenReturn(null);
			//w ktorym miejscy, metoda testowa, pod configuracja ?
		}

}
	
