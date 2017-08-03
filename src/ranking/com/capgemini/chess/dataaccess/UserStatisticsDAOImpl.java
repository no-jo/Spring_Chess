package com.capgemini.chess.dataaccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.to.StatsComparator;
import com.capgemini.chess.to.UserStatisticsMapper;
import com.capgemini.chess.to.UserStatisticsTO;

@Repository
public class UserStatisticsDAOImpl implements UserStatisticsDAO {

	private Set<UserStatisticsEntity> stats = new HashSet<UserStatisticsEntity>();
	
	public UserStatisticsDAOImpl() {
		UserStatisticsEntity stat1 = new UserStatisticsEntity();
		stat1.setId(1L);
		stat1.setUserid(5L);
		stat1.setCurrentScoreSum(100);
		stat1.setLevel(7);
		stat1.setWins(3);
		stats.add(stat1);
		
		UserStatisticsEntity stat2 = new UserStatisticsEntity();
		stat2.setId(2L);
		stat2.setUserid(6L);
		stat2.setCurrentScoreSum(100);
		stat2.setLevel(7);
		stat2.setWins(4);
		stats.add(stat2);		
		
		UserStatisticsEntity stat3 = new UserStatisticsEntity();
		stat3.setId(3L);
		stat3.setUserid(7L);
		stat3.setCurrentScoreSum(100);
		stat3.setLevel(8);
		stat3.setWins(4);
		stats.add(stat3);
	}
	
	@Override
	public ArrayList<UserStatisticsTO> getAllSortedDescending() {
		ArrayList<UserStatisticsTO> list = new ArrayList<UserStatisticsTO>(getAll());
		list.sort(Collections.reverseOrder(new StatsComparator()));
		return list;
	}
	
	@Override
	public UserStatisticsTO addStats(UserStatisticsTO userStat) {
		stats.add(UserStatisticsMapper.map(userStat));
		return userStat;
	}

	@Override
	public List<UserStatisticsTO> getAll() {
		return stats.stream()
				.map(statEntity -> UserStatisticsMapper.map(statEntity)).collect(Collectors.toList());
	}

	@Override
	public UserStatisticsTO getUserStats(Long userID) {
		for (UserStatisticsEntity statistic : stats) {
			if (statistic.getUserid().equals(userID))
				return UserStatisticsMapper.map(statistic);
		}
		return null;
	}

	@Override
	public UserStatisticsTO update(UserStatisticsTO userStats) {
		stats.removeIf(stats -> stats.getUserid().equals(userStats.getUserid()));
		return addStats(userStats);
	}

}
