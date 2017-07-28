package com.capgemini.chess.ranking;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.dataaccess.UserStatisticsDAOImpl;
import com.capgemini.chess.to.UserStatisticsTO;

public class UserStatisticsDAOImplTest {

	UserStatisticsDAOImpl dao;
	
	@Before
	public void setUp() {
		dao = new UserStatisticsDAOImpl();
		initializeData();
	}
	

	@Test
	public void testGetAllSortedDescending() {
		//when
		List<UserStatisticsTO> list = dao.getAllSortedDescending();
		//then
		assertEquals(3L, list.get(0).getId());
		assertEquals(2L, list.get(1).getId());
		assertEquals(1L, list.get(2).getId());
	}

	@Test
	public void testGetAll() {
		//when
		List<UserStatisticsTO> list = dao.getAll();
		
		//then
		assertEquals(3, list.size());
	}

	private void initializeData() {
		UserStatisticsTO stat1 = new UserStatisticsTO();
		stat1.setId(1L);
		stat1.setUserid(5L);
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(7);
		stat1.setWins(3);
		dao.addStats(stat1);
		
		UserStatisticsTO stat2 = new UserStatisticsTO();
		stat2.setId(2L);
		stat2.setUserid(6L);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(4);
		dao.addStats(stat2);		
		
		UserStatisticsTO stat3 = new UserStatisticsTO();
		stat3.setId(3L);
		stat3.setUserid(7L);
		stat3.setCurrentScoreSum(100);
		stat3.setLevel(8);
		stat3.setWins(4);
		dao.addStats(stat3);
	}
}
