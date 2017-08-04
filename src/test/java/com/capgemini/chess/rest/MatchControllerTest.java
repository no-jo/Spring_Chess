package com.capgemini.chess.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.chess.Facade;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.service.to.MatchPointsTO;
import com.capgemini.chess.service.to.MatchResultsCTO;
import com.capgemini.chess.service.to.MatchTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class MatchControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private Facade facade;
	@InjectMocks
	private MatchController matchController;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(matchController).build();
	}
	
	@Test
	public void shouldRegisterNewMatch() throws Exception {
		//given
		MatchTO match = createSourceMatch();
		String jsonMatch = new ObjectMapper().writeValueAsString(match);
		MatchResultsCTO expected = createExpectedMatchCTO();
		String jsonResultCTO = new ObjectMapper().writeValueAsString(expected);
		Mockito.when(facade.registerMatch(Mockito.any(MatchTO.class))).thenReturn(expected);
		//when
		ResultActions resultActions = mockMvc.perform(post("/match")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMatch));
		//then
		resultActions.andExpect(content().json(jsonResultCTO));
	}

	private MatchResultsCTO createExpectedMatchCTO() {
		MatchResultsCTO result = new MatchResultsCTO();
		result.setMatchID(6L);
		result.setOpponentID(3L);
		ArrayList<MatchPointsTO> list = new ArrayList<MatchPointsTO>();
		list.add(new MatchPointsTO(3L, 100, MatchResult.WON));
		list.add(new MatchPointsTO(4L, -80, MatchResult.LOST));
		return result;
	}

	private MatchTO createSourceMatch() {
		MatchTO result = new MatchTO();
		result.setMatchID(6L);
		result.setOpponentID(3L);
		result.setOpponentResult(MatchResult.WON);
		return result;
	}

}
