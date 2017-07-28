package com.capgemini.chess.ranking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({StatsComparatorTest.class, UserStatisticsDAOImplTest.class, RankingServiceImplTest.class})
public class RankingTestSuite {

}
