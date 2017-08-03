package com.capgemini.chess.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chess.dataaccess.objects.UserProfileDAO;
import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.tos.UserProfileTO;


@RestController
@RequestMapping ("/profile")
public class ProfileController {

	@Autowired
	private UserProfileDAO userDAO;

	@RequestMapping(method = RequestMethod.DELETE)
	public UserProfileTO deleteProfile(@RequestParam("id") Long id) {
		return userDAO.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public UserProfileTO getUserProfile(@RequestParam("id") Long id) throws UserNotFoundException {
		return userDAO.readProfile(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public UserProfileTO updateProfile(@RequestBody UserProfileTO profile) throws EmailAlreadyExists {
		return userDAO.update(profile);
	}
}