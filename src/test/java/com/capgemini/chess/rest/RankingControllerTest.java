package com.capgemini.chess.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.chess.Facade;
import com.capgemini.chess.to.UserStatisticsTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class RankingControllerTest {

	private MockMvc mockMvc;

	@Mock
	private Facade facade;
	@InjectMocks
	private RankingController rankingController;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(rankingController).build();
	}
	
	@Test
	public void shouldGetRanking() throws Exception {
		//given
		ArrayList<UserStatisticsTO> ranking = new ArrayList<UserStatisticsTO>();
		ranking.add(new UserStatisticsTO(2L, 6L, 100, 7, 4, 0, 0));
		ranking.add(new UserStatisticsTO(1L, 5L, 100, 7, 3, 0, 0));
		Mockito.when(facade.getRanking()).thenReturn(ranking);
		String jsonRanking = new ObjectMapper().writeValueAsString(ranking);
		//when
		ResultActions effect = mockMvc.perform(get("/ranking"));
		//then
		effect.andExpect(content().json(jsonRanking));
	}

	@Test
	public void shouldGiveUserPosition() throws Exception {
		//given
		Mockito.when(facade.getUserRankingPosition(Mockito.anyLong())).thenReturn(2);
		//when then
		mockMvc.perform(post("/ranking").param("id", "4")).andExpect(content().string("2"));
	}

}
