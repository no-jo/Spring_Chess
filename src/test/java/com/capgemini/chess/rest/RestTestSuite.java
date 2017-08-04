package com.capgemini.chess.rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MatchControllerTest.class, ProfileControllerTest.class, RankingControllerTest.class })
public class RestTestSuite {

}
