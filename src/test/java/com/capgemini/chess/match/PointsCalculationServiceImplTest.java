package com.capgemini.chess.match;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.MatchStatus;
import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.services.PointsCalculationService;
import com.capgemini.chess.services.PointsCalculationServiceImpl;
import com.capgemini.chess.to.UserStatisticsTO;

@RunWith(MockitoJUnitRunner.class)
public class PointsCalculationServiceImplTest {

	private PointsCalculationService pointService;
	
	@Mock
	private UserStatisticsDAO statDao;
	
	@Before
	public void setUp() {
		pointService = new PointsCalculationServiceImpl(statDao);
	}

	@Test
	public void testCalculatePoints() {
		//given
		MatchTO match = new MatchTO();
		match.setChallengerID(1L);
		match.setChallengerResult(MatchResult.WON);
		match.setMatchID(900L);
		match.setOpponentID(2L);
		match.setOpponentResult(MatchResult.LOST);
		match.setStatus(MatchStatus.COMPLETED);
		
		UserStatisticsTO stat1 = new UserStatisticsTO();
		stat1.setLevel(3);
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat2.setLevel(5);
		
		Mockito.when(statDao.getUserStats(1L)).thenReturn(stat1);
		Mockito.when(statDao.getUserStats(2L)).thenReturn(stat2);
		
		List<MatchPointsTO> result = null;
		//when
		result = pointService.calculatePoints(match);
		
		//then
		assertEquals(90, result.get(0).getScoreIncrement());
		assertEquals(-20, result.get(1).getScoreIncrement());		
	}
}
