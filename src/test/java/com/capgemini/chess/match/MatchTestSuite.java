package com.capgemini.chess.match;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MatchHistoryDAOImplTest.class, UserStatisticsUpdateServiceImplTest.class,
		PointsCalculationServiceImplTest.class })
public class MatchTestSuite {

}
