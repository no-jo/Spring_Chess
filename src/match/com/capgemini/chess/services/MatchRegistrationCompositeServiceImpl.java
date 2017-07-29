package com.capgemini.chess.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.service.to.MatchResultsCTO;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class MatchRegistrationCompositeServiceImpl implements MatchRegistrationCompositeService {

	@Autowired
	private PointsCalculationService pointsCalculator;
	@Autowired
	private UserStatisticsUpdateService statsUpdater;
	@Autowired
	private MatchHistoryUpdateService historyUpdater;
	
	@Override
	public MatchResultsCTO register(MatchTO match) {
		List<MatchPointsTO> results = pointsCalculator.calculatePoints(match);
		statsUpdater.update(results);
		MatchResultsCTO matchInfo = new MatchResultsCTO(match, results);
		matchInfo = historyUpdater.update(matchInfo);
		return matchInfo;
	}

	public void setPointsCalculator(PointsCalculationService pointsCalculator) {
		this.pointsCalculator = pointsCalculator;
	}

	public void setStatsUpdater(UserStatisticsUpdateService statsUpdater) {
		this.statsUpdater = statsUpdater;
	}

	public void setHistoryUpdater(MatchHistoryUpdateService historyUpdater) {
		this.historyUpdater = historyUpdater;
	}

}
