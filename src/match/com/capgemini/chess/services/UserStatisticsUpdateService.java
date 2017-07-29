package com.capgemini.chess.services;

import java.util.List;

import com.capgemini.chess.service.to.MatchPointsTO;

public interface UserStatisticsUpdateService {
	
	List<MatchPointsTO> update(List<MatchPointsTO> points);
}
