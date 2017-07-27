package com.capgemini.chess;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.statsTO;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

public interface Facade {
	
	UserProfileTO updateProfile(UserProfileTO newProfile) throws EmailAlreadyExists;
	statsTO getRanking(Long userID);
	MatchTO registerMatch(MatchTO match);
	AccountTO changePassword(AccountTO account) throws InvalidPassword;
}
