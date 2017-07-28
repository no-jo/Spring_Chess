package com.capgemini.chess.dataaccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.to.StatsComparator;
import com.capgemini.chess.to.UserStatisticsMapper;
import com.capgemini.chess.to.UserStatisticsTO;

@Repository
public class UserStatisticsDAOImpl implements UserStatisticsDAO {

	private Set<UserStatisticsEntity> stats = new HashSet<UserStatisticsEntity>();
	
	@Override
	public List<UserStatisticsTO> getAllSortedDescending() {
		List<UserStatisticsTO> list = getAll();
		list.sort(Collections.reverseOrder(new StatsComparator()));
		return list;
	}
	
	@Override
	public UserStatisticsTO addStats(UserStatisticsTO userStat) {
		stats.add(UserStatisticsMapper.map(userStat));
		return null;
	}

	@Override
	public List<UserStatisticsTO> getAll() {
		List<UserStatisticsEntity> enList = new ArrayList<>(stats);
		List<UserStatisticsTO> list = new ArrayList<UserStatisticsTO>();
		list = UserStatisticsMapper.map2TOs(enList);
		return list;
	}

}
