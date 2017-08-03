package com.capgemini.chess.rest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.capgemini.chess.Facade;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.MatchStatus;
import com.capgemini.chess.service.to.MatchTO;

@RunWith(MockitoJUnitRunner.class)
public class MatchControllerTest {
//TODO napisac testy a jesli nie to ususnac mach controller
	private MockMvc mockMvc;

	@Mock
	private Facade facade;
	@InjectMocks
	private MatchController matchController;
	
	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(matchController).setViewResolvers(viewResolver).build();
	}
	
	@Test
	public void shouldRegisterNewMatch() throws Exception {
		// given
//		 {LocalDate date;
//		Long challengerID;
//		Long opponentID;
//		MatchResult challengerResult;
//		MatchResult opponentResult;
//		Long matchID;
//		MatchStatus status;}
		MatchTO newMatch = new MatchTO();
		newMatch.setMatchID(4L);
		newMatch.setOpponentResult(MatchResult.LOST);
		//when
		//ResultActions resultActions = mockMvc.perform(post("/match").contentType(MediaType.APPLICATION_JSON).content(json)));
	}

}
