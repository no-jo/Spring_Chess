package com.capgemini.chess.match;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.dataaccess.MatchHistoryDAO;
import com.capgemini.chess.dataaccess.MatchHistoryDAOImpl;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.MatchStatus;
import com.capgemini.chess.service.to.MatchResultsCTO;

public class MatchHistoryDAOImplTest {
	
	private MatchHistoryDAO matchDao;

	@Before
	public void setUp() {
		matchDao = new MatchHistoryDAOImpl();
		generateDummyData();
	}
	
	@Test
	public void shouldFindMatch() {
		//given
		Long L = 2000L;
		//when
		MatchResultsCTO result = matchDao.getMatch(1000L);
		//then
		assertEquals(L, result.getOpponentID());
	}

	@Test
	public void findsTwoMatchesByUser() {
		//when
		List<MatchResultsCTO> result = matchDao.getMatchesByUser(2000L);
		//then
		assertEquals(2, result.size());
	}
	
	@Test
	public void findsNoMatches() {
		//when
		List<MatchResultsCTO> result = matchDao.getMatchesByUser(2L);
		//then
		assertEquals(0, result.size());
	}

	private void generateDummyData() {
		MatchResultsCTO matchTO = new MatchResultsCTO();
		matchTO.setMatchID(1000L);
		matchTO.setOpponentID(2000L);
		matchTO.setChallengerID(2010L);
		matchTO.setOpponentResult(MatchResult.LOST);
		matchTO.setChallengerResult(MatchResult.WON);
		matchTO.setStatus(MatchStatus.COMPLETED);
		matchDao.add(matchTO);
		
		MatchResultsCTO match2 = new MatchResultsCTO();
		match2.setMatchID(100L);
		match2.setOpponentID(200L);
		match2.setChallengerID(2000L);
		match2.setOpponentResult(MatchResult.LOST);
		match2.setChallengerResult(MatchResult.WON);
		match2.setStatus(MatchStatus.COMPLETED);
		matchDao.add(matchTO);
		return;
	}
}
