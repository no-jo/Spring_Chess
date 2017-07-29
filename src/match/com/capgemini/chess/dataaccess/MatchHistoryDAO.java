package com.capgemini.chess.dataaccess;

import java.util.List;

import com.capgemini.chess.service.to.MatchResultsCTO;

public interface MatchHistoryDAO {
	
	MatchResultsCTO add(MatchResultsCTO newMatch);
	MatchResultsCTO getMatch(Long matchID);
	List<MatchResultsCTO> getMatchesByUser(Long userID);
	List<MatchResultsCTO> getAll();
	
}
