package com.capgemini.chess.services;

import com.capgemini.chess.service.to.MatchResultsCTO;
import com.capgemini.chess.service.to.MatchTO;

public interface MatchRegistrationCompositeService {
	
	MatchResultsCTO register(MatchTO match);

}
