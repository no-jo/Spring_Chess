package com.capgemini.chess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capgemini.chess.match.MatchTestSuite;
import com.capgemini.chess.ranking.RankingTestSuite;
import com.capgemini.chess.rest.RestTestSuite;
import com.capgemini.chess.userprofile.UserProfileTestSuite;

@RunWith(Suite.class)
@SuiteClasses({UserProfileTestSuite.class, RankingTestSuite.class,
	FacadeImplIntegrationTest.class, MatchTestSuite.class, RestTestSuite.class})
public class AllTests {

}
