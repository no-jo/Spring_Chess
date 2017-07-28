package com.capgemini.chess;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.exceptions.UserNotFound;
import com.capgemini.chess.service.AccountService;
import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.RankingService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.to.UserStatisticsTO;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

@Service
public class FacadeImpl implements Facade {
	
	@Autowired
	private ProfileService profileService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private RankingService rankingService;
	
	@Override
	public UserProfileTO updateProfile(UserProfileTO newProfile) throws EmailAlreadyExists {
		return profileService.update(newProfile);
	}

	@Override
	public AccountTO changePassword(AccountTO account) throws InvalidPassword {
		return accountService.changePassword(account);
	};	
	
	@Override
	public ArrayList<UserStatisticsTO> getRanking() {
		return rankingService.getAllUsersRanking();
	}
	
	@Override
	public int getUserRankingPosition(Long userID) throws UserNotFound {
		return rankingService.getPosition(userID);
	}

	@Override
	public MatchTO registerMatch(MatchTO match) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setRankingService(RankingService rankingService) {
		this.rankingService = rankingService;
	}
}
