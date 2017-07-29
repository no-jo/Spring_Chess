package com.capgemini.chess.dataaccess;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.to.UserStatisticsTO;

public interface UserStatisticsDAO {
	
	List<UserStatisticsTO> getAll();
	ArrayList<UserStatisticsTO> getAllSortedDescending();
	UserStatisticsTO addStats(UserStatisticsTO userStat);
	UserStatisticsTO getUserStats(Long userID);
	UserStatisticsTO update(UserStatisticsTO userStats);
	
}
