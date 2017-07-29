package com.capgemini.chess.dataaccess;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.service.to.MatchMapper;
import com.capgemini.chess.service.to.MatchResultsCTO;

@Repository
public class MatchHistoryDAOImpl implements MatchHistoryDAO {

	private Set<MatchResultsEntity> matchHistory = new HashSet<MatchResultsEntity>();

	@Override
	public MatchResultsCTO add(MatchResultsCTO newMatch) {
		if (newMatch != null) {
			matchHistory.add(MatchMapper.map(newMatch));
		}
		return newMatch;
	}

	@Override
	public MatchResultsCTO getMatch(Long matchID) {
		for (MatchResultsEntity match : matchHistory) {
			if (match.getMatchID().equals(matchID))
				return MatchMapper.map(match);
		}
		return null;		
	}

	@Override
	public List<MatchResultsCTO> getMatchesByUser(Long userID) {
		return matchHistory.stream().map(match -> MatchMapper.map(match))
				.filter(match -> match.getChallengerID().equals(userID) || match.getOpponentID().equals(userID))
				.collect(Collectors.toList());
	}

	@Override
	public List<MatchResultsCTO> getAll() {
		return matchHistory.stream().map(match -> MatchMapper.map(match)).collect(Collectors.toList());
	}
}
