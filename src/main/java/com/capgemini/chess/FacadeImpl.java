package com.capgemini.chess;

import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.statsTO;

public class FacadeImpl implements Facade {
	
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
