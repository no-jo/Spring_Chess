package com.capgemini.chess.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.UserStatisticsDAO;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.to.UserStatisticsTO;

@Service
public class RankingServiceImpl implements RankingService {
	
	//@Autowired
	private UserStatisticsDAO statDao = null;	

	
	@Autowired
	public RankingServiceImpl(UserStatisticsDAO statDao) {
		this.statDao = statDao;
	}

	@Override
	public int getPosition(Long userID) throws UserNotFoundException {
		return getPosition(userID, getAllUsersRanking());
	}

	@Override
	public int getPosition(Long userID, List<UserStatisticsTO> list) throws UserNotFoundException {
		int pos = 1;
		for (UserStatisticsTO user : list) {
			if (user.getUserid().equals(userID)) {
				return pos;
			}
			pos++;
		}
		throw new UserNotFoundException();
	}
	
	@Override
	public ArrayList<UserStatisticsTO> getAllUsersRanking() {
		return statDao.getAllSortedDescending();
	}
}
