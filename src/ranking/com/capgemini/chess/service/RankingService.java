package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.to.UserStatisticsTO;

public interface RankingService {
	
	int getPosition(Long userID) throws UserNotFound;
	int getPosition(Long userID, List<UserStatisticsTO> list) throws UserNotFound;
	List<UserStatisticsTO> getAllUsersRanking();
	
}
