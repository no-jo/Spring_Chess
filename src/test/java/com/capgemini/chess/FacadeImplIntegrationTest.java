package com.capgemini.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dataaccess.MatchHistoryDAO;
import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.objects.UserProfileDAO;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.MatchStatus;
import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.AccountService;
import com.capgemini.chess.service.EmailValidationService;
import com.capgemini.chess.service.PasswordValidator;
import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.RankingService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.services.MatchHistoryUpdateService;
import com.capgemini.chess.services.MatchRegistrationCompositeService;
import com.capgemini.chess.services.PointsCalculationService;
import com.capgemini.chess.services.UserStatisticsUpdateService;
import com.capgemini.chess.to.UserStatisticsTO;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (classes = ChessApplication.class)
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
	@Autowired
	MatchRegistrationCompositeService matchService;
	@Autowired
	PointsCalculationService pointsCalculator;
	@Autowired
	UserStatisticsUpdateService statsUpdater;
	@Autowired
	MatchHistoryUpdateService matchUpdater;
	@Autowired
	MatchHistoryDAO historyDao;
	
//	@Configuration
//	static class RankServiceTestContextConfiguration {
//		@Bean
//		public Facade Facade() {
//			return new FacadeImpl();
//		}
//		@Bean
//		public UserProfileDAO UserProfileDAO() {
//			return new UserProfileDAOImplMap();
//		}
//		@Bean
//		public EmailValidationService EmailValidationService() {
//			return new EmailValidationServiceImpl(UserProfileDAO());
//		}
//		@Bean
//		public ProfileService ProfileService() {
//			return new ProfileServiceImpl();
//		}
//		@Bean
//		public PasswordValidator PasswordValidator() {
//			return new PasswordValidatorImpl();
//		}		
//		@Bean
//		public AccountService AccountService() {
//			return new AccountServiceImpl();
//		}
//		@Bean
//		public UserStatisticsDAO StatDaoSetUp() {
//			return new UserStatisticsDAOImpl();
//		}
//		@Bean
//		public RankingService RankingServSetUp() {
//			return new RankingServiceImpl(StatDaoSetUp());
//		}
//		@Bean
//		public MatchRegistrationCompositeService Composite() {
//			return new MatchRegistrationCompositeServiceImpl();
//		}
//		@Bean
//		public PointsCalculationService setMatchRegister() {
//			return new PointsCalculationServiceImpl(StatDaoSetUp());
//		}
//		@Bean
//		public UserStatisticsUpdateService statsUpdaterset() {
//			return new UserStatisticsUpdateServiceImpl(StatDaoSetUp());
//		}
//		@Bean
//		public MatchHistoryUpdateService setUpmatchUpdater() {
//			return new MatchHistoryUpdateServiceImpl();
//		}
//		@Bean
//		public MatchHistoryDAO setUphistoryDao() {
//			return new MatchHistoryDAOImpl();
//		}
//	}
	
	@Test
	public void shouldRegisterMatch() {
		//given
		MatchTO match = new MatchTO();
		match.setChallengerID(6L);
		match.setChallengerResult(MatchResult.LOST);
		match.setMatchID(999L);
		match.setOpponentID(7L);
		match.setOpponentResult(MatchResult.WON);
		match.setStatus(MatchStatus.COMPLETED);
		//when
		facade.registerMatch(match);
		//then
		assertEquals(1, historyDao.getAll().size());
	}
	
	@Test
	public void shouldSuccesfullyUpdateEmail() throws EmailAlreadyExists, UserNotFoundException {
		//given
		addUserEntities();
		//when
		UserProfileTO newProfile = new UserProfileTO();
		newProfile.setId(3L);
		newProfile.setEmail("new@email.com");
		facade.updateProfile(newProfile);
		
		//then
		assertEquals("new@email.com", dao.readProfile(3L).getEmail());
	}
	
	@Test (expected = EmailAlreadyExists.class)
	public void shouldThrowExceptionForDuplicatedEmail() throws EmailAlreadyExists, UserNotFoundException {
		//given
		addUserEntities();
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
		//given
		addUserEntities();
		//when
		facade.changePassword(new AccountTO(10L, "sample_log", "pass"));
		//then
		fail("Password not validated correctly");
	}
	
	@Test 
	public void shouldUpdatePasswordCorrectly() throws InvalidPassword, UserNotFoundException {
		//given
		addUserEntities();
		//when
		facade.changePassword(new AccountTO(10L, "sample", "PASS"));
		//then
		assertEquals("PASS", dao.readAccount(10L).getPassword());
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
