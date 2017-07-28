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

}
