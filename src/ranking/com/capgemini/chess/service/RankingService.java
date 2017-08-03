package com.capgemini.chess.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.to.UserStatisticsTO;

public interface RankingService {
	
	int getPosition(Long userID) throws UserNotFoundException;
	int getPosition(Long userID, List<UserStatisticsTO> list) throws UserNotFoundException;
	ArrayList<UserStatisticsTO> getAllUsersRanking();
	
}
