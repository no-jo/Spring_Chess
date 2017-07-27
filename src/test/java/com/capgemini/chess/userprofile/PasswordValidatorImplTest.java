package com.capgemini.chess.userprofile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.exceptions.InvalidPassword;
import com.capgemini.chess.service.impl.PasswordValidatorImpl;

public class PasswordValidatorImplTest {

	PasswordValidatorImpl passvalid;
	
	@Before
	public void setUp() {
		passvalid = new PasswordValidatorImpl();
	}
	
	@Test
	public void shouldPasswordPassValidation() throws InvalidPassword {
		//when
		passvalid.validatePassword("ASIA");
		
		//then no exception
		
	}
	
	@Test (expected = InvalidPassword.class)
	public void shouldThowExceptionWithSpecialChars() throws InvalidPassword {
		//when
		passvalid.validatePassword("ASIA!!");
		
		//then no exception
		fail("Expected exception was not thrown");
	}
	
	@Test (expected = InvalidPassword.class)
	public void shouldThrowExceptionOnlyLowerCase() throws InvalidPassword {
		//when
		passvalid.validatePassword("asia");
		
		//then no exception
		fail("Expected exception was not thrown");
		
	}

}
