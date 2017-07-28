package com.capgemini.chess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capgemini.chess.ranking.RankingTestSuite;
import com.capgemini.chess.userprofile.UserProfileTestSuite;

@RunWith(Suite.class)
@SuiteClasses({UserProfileTestSuite.class, RankingTestSuite.class, FacadeImplIntegrationTest.class})
public class AllTests {

}
