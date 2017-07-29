package com.capgemini.chess.services;

import java.util.List;

import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.service.to.MatchTO;

public interface PointsCalculationService {
	
	List<MatchPointsTO> calculatePoints(MatchTO match);

}
