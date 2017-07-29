package com.capgemini.chess.service.to;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.MatchResultsEntity;

public class MatchMapper {
	
	public static MatchResultsCTO map(MatchResultsEntity matchEntity) {
		if (matchEntity != null) {
			MatchResultsCTO matchTO = new MatchResultsCTO();
			matchTO.setDate(matchEntity.getDate());
			matchTO.setMatchID(matchEntity.getMatchID());
			matchTO.setOpponentID(matchEntity.getOpponentID());
			matchTO.setChallengerID(matchEntity.getChallengerID());
			matchTO.setStatus(matchEntity.getStatus());
			
			MatchPointsTO p1 = new MatchPointsTO();
			p1.setResult(matchEntity.getChallengerResult());
			p1.setScoreIncrement(matchEntity.getChallengerScore());
			p1.setUserID(matchEntity.getChallengerID());
			matchTO.getMatchPoints().add(p1);			
			
			MatchPointsTO p2 = new MatchPointsTO();
			p2.setResult(matchEntity.getOpponentResult());
			p2.setScoreIncrement(matchEntity.getOpponentScore());
			p2.setUserID(matchEntity.getOpponentID());
			matchTO.getMatchPoints().add(p2);
			
			return matchTO;
		}
		return null;
	}
	
	public static MatchResultsEntity map(MatchResultsCTO matchTO) {
		if (matchTO != null) {
			MatchResultsEntity matchEntity = new MatchResultsEntity();
			matchEntity.setDate(matchTO.getDate());
			matchEntity.setMatchID(matchTO.getMatchID());
			matchEntity.setOpponentID(matchTO.getOpponentID());
			matchEntity.setChallengerID(matchTO.getChallengerID());
			matchEntity.setStatus(matchTO.getStatus());
			
			MatchPointsTO challengerPoints = null;
			MatchPointsTO opponentPoints = null;
			
			if ((matchTO.getChallengerID()).equals(matchTO.getMatchPoints().get(0).getUserID())) {
				challengerPoints = matchTO.getMatchPoints().get(0);
				opponentPoints = matchTO.getMatchPoints().get(1);
			} else {
				challengerPoints = matchTO.getMatchPoints().get(1);
				opponentPoints = matchTO.getMatchPoints().get(0);
			}

			matchEntity.setChallengerResult(challengerPoints.getResult());
			matchEntity.setChallengerScore(challengerPoints.getScoreIncrement());
			matchEntity.setOpponentResult(opponentPoints.getResult());
			matchEntity.setOpponentScore(opponentPoints.getScoreIncrement());
			
			return matchEntity;
		}
		return null;
	}
	
	public static List<MatchResultsCTO> map2TOs(List<MatchResultsEntity> userEntities) {
		return userEntities.stream().map(MatchMapper::map).collect(Collectors.toList());
	}

	public static List<MatchResultsEntity> map2Entities(List<MatchResultsCTO> userTOs) {
		return userTOs.stream().map(MatchMapper::map).collect(Collectors.toList());
	}
	
}
