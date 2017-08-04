package com.capgemini.chess.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chess.Facade;
import com.capgemini.chess.service.to.MatchResultsCTO;
import com.capgemini.chess.service.to.MatchTO;

@RestController
@RequestMapping ("/match")
public class MatchController {	

	@Autowired
	private Facade facade;
	
	@RequestMapping(method = RequestMethod.POST)
	public MatchResultsCTO registerMatch(@RequestBody MatchTO match) {
		return facade.registerMatch(match);
	}

}
