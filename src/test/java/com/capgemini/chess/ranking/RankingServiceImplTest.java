package com.capgemini.chess.ranking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.service.RankingServiceImpl;
import com.capgemini.chess.to.UserStatisticsTO;

@RunWith(MockitoJUnitRunner.class)
public class RankingServiceImplTest {

	private RankingServiceImpl rankingService;
	@Mock
	private UserStatisticsDAO statDao;
		
	@Before
	public void setUp() {
		rankingService = new RankingServiceImpl(statDao);
	}

	@Test
	public void shouldReturnOneOfThree() throws UserNotFound {
		//given
		Mockito.when(statDao.getAllSortedDescending()).thenReturn(getDummyStats());
		//Mockito.when(rankingService.getAllUsersRanking()).thenReturn(getDummyStats());
		//when
		int pos = rankingService.getPosition(7L);
		//then
		assertEquals(3, pos);		
	}
	
	@Test
	public void shouldGiveAll() {
		//given
		Mockito.when(statDao.getAllSortedDescending()).thenReturn(getDummyStats());
		//when
		List<UserStatisticsTO> result = rankingService.getAllUsersRanking();
		//then
		assertEquals(3, result.size());
	}

	private ArrayList<UserStatisticsTO> getDummyStats() {
		ArrayList<UserStatisticsTO> users = new ArrayList<UserStatisticsTO>();
		
		UserStatisticsTO stat1 = new UserStatisticsTO();
		stat1.setId(1L);
		stat1.setUserid(5L);
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(7);
		stat1.setWins(3);
		users.add(stat1);
		
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat2.setId(2L);
		stat2.setUserid(6L);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(4);
		users.add(stat2);		
		
		UserStatisticsTO stat3 = new UserStatisticsTO();
		stat3.setId(3L);
		stat3.setUserid(7L);
		stat3.setCurrentScoreSum(100);
		stat3.setLevel(8);
		stat3.setWins(4);
		users.add(stat3);
		
		return users;
	}
}
