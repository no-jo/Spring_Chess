package com.capgemini.chess.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chess.Facade;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.to.UserStatisticsTO;

@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired 
	private Facade facade;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ArrayList<UserStatisticsTO> getRanking() {
		return facade.getRanking();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int getUserPosition(@RequestParam("id") Long id) throws UserNotFoundException {
		return facade.getUserRankingPosition(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String acceptArrayForRanking(@RequestBody UserStatisticsTO[] newStats) {
		return "Array was passed as argument";
	}

}
