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
			matchTO.setOpponentResult(matchEntity.getOpponentResult());
			matchTO.setChallengerResult(matchEntity.getChallengerResult());
			matchTO.setStatus(matchEntity.getStatus());
			matchTO.setChallengerScore(matchEntity.getChallengerScore());
			matchTO.setOpponentScore(matchEntity.getOpponentScore());
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
			matchEntity.setOpponentResult(matchTO.getOpponentResult());
			matchEntity.setChallengerResult(matchTO.getChallengerResult());
			matchEntity.setStatus(matchTO.getStatus());
			matchEntity.setChallengerScore(matchTO.getChallengerScore());
			matchEntity.setOpponentScore(matchTO.getOpponentScore());
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
