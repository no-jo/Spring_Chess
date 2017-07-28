package com.capgemini.chess.userprofile;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmailValidationServiceImplTest.class, PasswordValidatorImplTest.class, UserProfileDAOImplMapTest.class})
public class UserProfileTestSuite {

}
