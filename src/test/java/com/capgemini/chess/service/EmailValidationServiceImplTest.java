package com.capgemini.chess.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.chess.exceptions.EmailAlreadyExists;
import com.capgemini.chess.profileDAO.UserProfileDAO;
import com.capgemini.chess.service.impl.EmailValidationServiceImpl;
import com.capgemini.chess.service.to.UserProfileTO;

//@RunWith(MockitoJUnitRunner.class)
public class EmailValidationServiceImplTest {

	EmailValidationServiceImpl service = null;
	@Mock
	UserProfileDAO profileDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new EmailValidationServiceImpl(profileDao);
	}

	@Test
	public void shouldValidateEmail() throws EmailAlreadyExists {
		// when
		Mockito.when(profileDao.findByEmail("a")).thenReturn(null);
		service.validateEmail("a");

		// then no exception

	}

	@Test(expected = EmailAlreadyExists.class)
	public void shouldThrowException() throws EmailAlreadyExists {
		// when
		Mockito.when(profileDao.findByEmail("b")).thenReturn(new UserProfileTO());
		service.validateEmail("b");

		// then exception
	}

}
