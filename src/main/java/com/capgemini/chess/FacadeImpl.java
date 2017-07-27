package com.capgemini.chess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.service.AccountService;
import com.capgemini.chess.service.ProfileService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.statsTO;
import com.capgemini.chess.tos.AccountTO;
import com.capgemini.chess.tos.UserProfileTO;

@Service
public class FacadeImpl implements Facade {
	
	@Autowired
	private ProfileService profileService;
	@Autowired
	private AccountService accountService;
	
	@Override
	public UserProfileTO updateProfile(UserProfileTO newProfile) throws EmailAlreadyExists {
		return profileService.update(newProfile);
	}

	@Override
	public AccountTO changePassword(AccountTO account) throws InvalidPassword {
		return accountService.changePassword(account);
	};
	
	@Override
	public statsTO getRanking(Long userID) {
		// TODO Auto-generated method stub
		return null;
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
}
