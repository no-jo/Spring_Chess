package com.capgemini.chess.dataaccess;

import java.util.List;

import com.capgemini.chess.to.UserStatisticsTO;

public interface UserStatisticsDAO {
	
	List<UserStatisticsTO> getAll();
	List<UserStatisticsTO> getAllSortedDescending();
	UserStatisticsTO addStats(UserStatisticsTO userStat);
	
}
