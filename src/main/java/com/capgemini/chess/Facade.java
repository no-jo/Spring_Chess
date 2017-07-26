package com.capgemini.chess;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.service.to.AccountTO;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.statsTO;

public interface Facade {
	
	UserProfileTO updateProfile(UserProfileTO newProfile) throws EmailAlreadyExists;
	statsTO getStats(Long userID);
	MatchTO updateRanking(MatchTO match);
	AccountTO changePassword(AccountTO account) throws InvalidPassword;
}
