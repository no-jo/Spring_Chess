package com.capgemini.chess;

import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.statsTO;

public interface Facade {
	
	UserProfileTO updateProfile(UserProfileTO newProfile);
	statsTO getStats(Long userID);
	MatchTO updateRanking(MatchTO match);
}
