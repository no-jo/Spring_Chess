package com.capgemini.chess.ranking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capgemini.chess.service.RankingServiceImpl;


@RunWith(Suite.class)
@SuiteClasses({StatsComparatorTest.class, UserStatisticsDAOImplTest.class, RankingServiceImpl.class})
public class RankingTestSuite {

}
