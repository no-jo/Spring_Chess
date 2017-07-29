package com.capgemini.chess.services;

import com.capgemini.chess.service.to.MatchResultsCTO;

public interface MatchHistoryUpdateService {
	
	MatchResultsCTO update(MatchResultsCTO results);
	
}
