package com.capgemini.chess.ranking;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.to.StatsComparator;
import com.capgemini.chess.to.UserStatisticsTO;

public class StatsComparatorTest {

	@Test
	public void testShouldBeEqual() {
		StatsComparator comparator = new StatsComparator();
		UserStatisticsTO stat1 = new UserStatisticsTO();
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(7);
		stat1.setWins(3);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(3);
		// when
		int result = comparator.compare(stat1, stat2);
		// then
		assertEquals(0, result);
	}

	@Test
	public void testFirstIsBiggerByWins() {
		StatsComparator comparator = new StatsComparator();
		UserStatisticsTO stat1 = new UserStatisticsTO();
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(7);
		stat1.setWins(6);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(3);
		// when
		int result = comparator.compare(stat1, stat2);
		// then
		assertEquals(1, result);
	}

	@Test
	public void testFirstIsBigger() {
		StatsComparator comparator = new StatsComparator();
		UserStatisticsTO stat1 = new UserStatisticsTO();
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat1.setCurrentScoreSum(600);
		stat1.setLevel(2);
		stat1.setWins(1);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(3);
		// when
		int result = comparator.compare(stat1, stat2);
		// then
		assertEquals(1, result);
	}

	@Test
	public void testFirstIsSmaller() {
		StatsComparator comparator = new StatsComparator();
		UserStatisticsTO stat1 = new UserStatisticsTO();
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(7);
		stat1.setWins(1);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(3);
		// when
		int result = comparator.compare(stat1, stat2);
		// then
		assertEquals(-1, result);
	}

	@Test
	public void testFirstIsSmallerByLevel() {
		StatsComparator comparator = new StatsComparator();
		UserStatisticsTO stat1 = new UserStatisticsTO();
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(5);
		stat1.setWins(10);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(3);
		// when
		int result = comparator.compare(stat1, stat2);
		// then
		assertEquals(-1, result);
	}

}
