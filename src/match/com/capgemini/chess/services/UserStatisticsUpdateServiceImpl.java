package com.capgemini.chess.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.to.UserStatisticsTO;

@Service
public class UserStatisticsUpdateServiceImpl implements UserStatisticsUpdateService {

	private UserStatisticsDAO statDao;
	
	@Autowired
	public UserStatisticsUpdateServiceImpl(UserStatisticsDAO statDao) {
		this.statDao = statDao;
	}
	
	@Override
	public List<UserStatisticsTO> update(List<MatchPointsTO> points) {
		List<UserStatisticsTO> groupStats = new ArrayList<UserStatisticsTO>();
		for (MatchPointsTO userPoints : points) {
			UserStatisticsTO userStats = statDao.getUserStats(userPoints.getUserID());
			userStats.setCurrentScoreSum(userStats.getCurrentScoreSum() + userPoints.getScoreIncrement());
			MatchResult res = userPoints.getResult();
				switch (res) {
				case WON: 
					userStats.setWins(userStats.getWins() + 1);
					break;
				
				case LOST: 
					userStats.setLoses(userStats.getLoses() + 1);
					break;
				
				case DRAW: 
					userStats.setDraws(userStats.getDraws() + 1);
					break;				
				}
				groupStats.add(statDao.update(userStats));
		}
		return groupStats;
	}

}
