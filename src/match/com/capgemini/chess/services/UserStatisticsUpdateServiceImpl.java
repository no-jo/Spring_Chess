package com.capgemini.chess.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.to.UserStatisticsTO;

@Service
public class UserStatisticsUpdateServiceImpl implements UserStatisticsUpdateService {

	@Autowired
	private UserStatisticsDAO statDao;
	
	@Override
	public List<MatchPointsTO> update(List<MatchPointsTO> points) {
		UserStatisticsTO userStats = null;
		for (MatchPointsTO userPoints : points) {
			userStats = statDao.getUserStats(userPoints.getUserID());
			userStats.setCurrentScoreSum(userStats.getCurrentScoreSum() + userPoints.getScoreIncrement());
			// TODO insert further update
		}
		return points;
	}

}
