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
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.capgemini.chess.Facade;
import com.capgemini.chess.to.UserStatisticsTO;

@RunWith(MockitoJUnitRunner.class)
public class RankingControllerTest {

	private MockMvc mockMvc;

	@Mock
	private Facade facade;
	@InjectMocks
	private RankingController rankingController;
	
	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(rankingController).setViewResolvers(viewResolver).build();
	}
	
	@Test
	public void shouldGetRanking() throws Exception {
		//given
		ArrayList<UserStatisticsTO> ranking = new ArrayList<UserStatisticsTO>();
		ranking.add(new UserStatisticsTO(2L, 6L, 100, 7, 4, 0, 0));
		ranking.add(new UserStatisticsTO(1L, 5L, 100, 7, 3, 0, 0));
		Mockito.when(facade.getRanking()).thenReturn(ranking);
		String jsonRanking = "[{\"id\":2,\"userid\":6,\"level\":7,\"wins\":4,\"loses\":0,\"draws\":0,\"currentScoreSum\":100},{\"id\":1,\"userid\":5,\"level\":7,\"wins\":3,\"loses\":0,\"draws\":0,\"currentScoreSum\":100}]";
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
