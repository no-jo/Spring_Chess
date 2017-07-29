package com.capgemini.chess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.MatchHistoryDAO;
import com.capgemini.chess.service.to.MatchResultsCTO;

@Service
public class MatchHistoryUpdateServiceImpl implements MatchHistoryUpdateService {

	@Autowired
	MatchHistoryDAO matchDao;
	
	@Override
	public MatchResultsCTO update(MatchResultsCTO results) {
		return matchDao.add(results);
	}

	public void setMatchDao(MatchHistoryDAO matchDao) {
		this.matchDao = matchDao;
	}

}
