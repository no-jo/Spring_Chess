package com.capgemini.chess.services;

import java.util.List;

import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.to.UserStatisticsTO;

public interface UserStatisticsUpdateService {
	
	List<UserStatisticsTO> update(List<MatchPointsTO> points);
}
