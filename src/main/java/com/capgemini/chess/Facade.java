package com.capgemini.chess;

import java.util.ArrayList;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.to.MatchResultsCTO;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.to.UserStatisticsTO;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

public interface Facade {
	
	UserProfileTO updateProfile(UserProfileTO newProfile) throws EmailAlreadyExists;
	ArrayList<UserStatisticsTO> getRanking();
	int getUserRankingPosition(Long userID) throws UserNotFoundException;
	MatchResultsCTO registerMatch(MatchTO match);
	AccountTO changePassword(AccountTO account) throws InvalidPassword;
	UserProfileTO deleteProfile(Long id);
	UserProfileTO readProfile(Long id) throws UserNotFoundException;
}

