package com.capgemini.chess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.statsTO;

@Service
public class FacadeImpl implements Facade {
	
	@Autowired
	private ProfileService profileService;
	
	@Override
	public UserProfileTO updateProfile(UserProfileTO newProfile) {
		return profileService.update(newProfile);
	}

	@Override
	public statsTO getStats(Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchTO updateRanking(MatchTO match) {
		// TODO Auto-generated method stub
		return null;
	};
}
