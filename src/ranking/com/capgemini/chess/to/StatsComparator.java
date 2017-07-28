package com.capgemini.chess.to;

import java.util.Comparator;

public class StatsComparator implements Comparator<UserStatisticsTO> {

	@Override
	public int compare(UserStatisticsTO o1, UserStatisticsTO o2) {
		if (o1.getCurrentScoreSum() > o2.getCurrentScoreSum()) return 1;
		else if (o1.getCurrentScoreSum() == o2.getCurrentScoreSum()) {
			if (o1.getLevel() > o2.getLevel()) return 1;
			else if (o1.getLevel() == o2.getLevel()) {
				if (o1.getWins() > o2.getWins()) return 1;
				else if (o1.getWins() == o2.getWins()) return 0;
			}
		}
		return -1;
	}
}
