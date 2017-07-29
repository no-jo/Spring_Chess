package com.capgemini.chess.match;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.services.UserStatisticsUpdateService;
import com.capgemini.chess.services.UserStatisticsUpdateServiceImpl;
import com.capgemini.chess.to.UserStatisticsTO;

@RunWith(MockitoJUnitRunner.class)
public class UserStatisticsUpdateServiceImplTest {

	private UserStatisticsUpdateService userService;
	
	@Mock
	private UserStatisticsDAO statDao;
	
	@Before
	public void setUp() {
		userService = new UserStatisticsUpdateServiceImpl(statDao);
	}

	@Test
	public void shouldUpdateStitistics() {
		//given
		List<MatchPointsTO> points = new ArrayList<MatchPointsTO>();
		MatchPointsTO example = new MatchPointsTO();
		example.setResult(MatchResult.LOST);
		example.setScoreIncrement(-40);
		example.setUserID(100L);
		points.add(example);
		
		UserStatisticsTO mockReturn = new UserStatisticsTO();
		mockReturn.setCurrentScoreSum(300);
		mockReturn.setDraws(12);
		mockReturn.setWins(10);
		mockReturn.setLoses(10);
		mockReturn.setUserid(100L);
		
		Mockito.when(statDao.getUserStats(100L)).thenReturn(mockReturn);
		Mockito.when(statDao.update(Mockito.any())).then(AdditionalAnswers.returnsFirstArg());
		
		//when
		List<UserStatisticsTO> stats = new ArrayList<UserStatisticsTO>(userService.update(points));
		//then
		assertEquals(11, stats.get(0).getLoses());
		assertEquals(260, stats.get(0).getCurrentScoreSum());
	}

}
