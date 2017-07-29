package com.capgemini.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.dataaccess.UserStatisticsDAOImpl;
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
import com.capgemini.chess.service.RankingService;
import com.capgemini.chess.service.RankingServiceImpl;
import com.capgemini.chess.service.impl.AccountServiceImpl;
import com.capgemini.chess.service.impl.EmailValidationServiceImpl;
import com.capgemini.chess.service.impl.PasswordValidatorImpl;
import com.capgemini.chess.service.impl.ProfileServiceImpl;
import com.capgemini.chess.to.UserStatisticsTO;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FacadeImplIntegrationTest {
	
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
	@Autowired
	UserStatisticsDAO statDao;
	@Autowired
	RankingService rankService;
	
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
		@Bean
		public UserStatisticsDAO StatDaoSetUp() {
			return new UserStatisticsDAOImpl();
		}
		@Bean
		public RankingService RankingServSetUp() {
			return new RankingServiceImpl(StatDaoSetUp());
		};
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
	public void shouldReturnRanking() {
		//given 
		setDummyStats();
		//when
		ArrayList<UserStatisticsTO> ranking = facade.getRanking();
		Long L = 7L;
		//then
		assertEquals(3, ranking.size());
		assertEquals(L, ranking.get(0).getUserid());
	}
	
	@Test
	@Ignore //have to add teardown method
	public void shouldReturnPosition() {
		//given 
		setDummyStats();
		//when
		ArrayList<UserStatisticsTO> ranking = facade.getRanking();
		Long L = 7L;
		//then
		assertEquals(3, ranking.size());
		assertEquals(L, ranking.get(0).getUserid());
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
	
	private void setDummyStats() {
		
		UserStatisticsTO stat1 = new UserStatisticsTO();
		stat1.setId(1L);
		stat1.setUserid(5L);
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(7);
		stat1.setWins(3);
		statDao.addStats(stat1);
		
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat2.setId(2L);
		stat2.setUserid(6L);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(4);
		statDao.addStats(stat2);		
		
		UserStatisticsTO stat3 = new UserStatisticsTO();
		stat3.setId(3L);
		stat3.setUserid(7L);
		stat3.setCurrentScoreSum(100);
		stat3.setLevel(8);
		stat3.setWins(4);
		statDao.addStats(stat3);
	}
}