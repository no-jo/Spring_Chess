package com.capgemini.chess.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class PointsCalculationServiceImpl implements PointsCalculationService {

	private static final int CHALLENGER_BONUS = 50;

	private UserStatisticsDAO statDAO;
	
	@Autowired
	public PointsCalculationServiceImpl(UserStatisticsDAO statDAO){
		this.statDAO = statDAO;
	}

	@Override
	public List<MatchPointsTO> calculatePoints(MatchTO match) {
		List<MatchPointsTO> results = new ArrayList<MatchPointsTO>();
		int challengerLevel = statDAO.getUserStats(match.getChallengerID()).getLevel();
		int opponentLevel = statDAO.getUserStats(match.getOpponentID()).getLevel();

		MatchPointsTO challengerPointsTO = new MatchPointsTO();
		challengerPointsTO.setResult(match.getChallengerResult());
		challengerPointsTO.setUserID(match.getChallengerID());
		challengerPointsTO.setScoreIncrement(
				calculateScore(match.getChallengerResult(), challengerLevel, opponentLevel) + CHALLENGER_BONUS);
		MatchPointsTO opponentPointsTO = new MatchPointsTO();
		opponentPointsTO.setResult(match.getOpponentResult());
		opponentPointsTO.setUserID(match.getOpponentID());
		opponentPointsTO.setScoreIncrement(
				calculateScore(match.getOpponentResult(), opponentLevel, challengerLevel));
		results.add(challengerPointsTO);
		results.add(opponentPointsTO);
		return results;
	}

	public void setStatDAO(UserStatisticsDAO statDAO) {
		this.statDAO = statDAO;
	}

	private long calculateScore(MatchResult myResult, int myLevel, int opponentLevel) {
		int score = (opponentLevel - myLevel) * 20;
		if (score < 0) score *= -0.5;
		if (myResult == MatchResult.LOST)
			score *= -1;
		else if (myResult == MatchResult.DRAW)
			score *= 0.5;
		return score;
	}
}
