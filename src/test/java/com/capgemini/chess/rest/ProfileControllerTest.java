package com.capgemini.chess.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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
import com.capgemini.chess.tos.UserProfileTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {
	
	private MockMvc mockMvc;
	@Mock
	private Facade facade;
	@InjectMocks
	private ProfileController profileController;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
	}
	
	@Test
	public void testDeleteProfile() throws Exception {
		//given
		UserProfileTO profile1 = setDummyProfile();
		String jsonUser = new ObjectMapper().writeValueAsString(profile1);
		Mockito.when(facade.deleteProfile(500L)).thenReturn(profile1);
		//when
		ResultActions resultActions = mockMvc.perform(delete("/profile").param("id", "500"));
		//then
		resultActions.andExpect(content().json(jsonUser));
	}

	@Test
	public void shouldGetUserProfile() throws Exception {
		UserProfileTO profile1 = setDummyProfile();
		String jsonUser = new ObjectMapper().writeValueAsString(profile1);
		Mockito.when(facade.readProfile(3L)).thenReturn(profile1);
		//when
		ResultActions resultActions = mockMvc.perform(get("/profile").param("id", "3"));
		//then
		resultActions.andExpect(content().json(jsonUser));
	}

	@Test
	public void testUpdateProfile() throws Exception {
		UserProfileTO profile1 = setDummyProfile();
		String jsonUser = new ObjectMapper().writeValueAsString(profile1);
		Mockito.when(facade.updateProfile(Mockito.any(UserProfileTO.class))).thenReturn(profile1);
		//when
		ResultActions resultActions = mockMvc.perform(post("/profile").contentType(MediaType.APPLICATION_JSON)
				.content(jsonUser));
		//then
		resultActions.andExpect(content().json(jsonUser));
	}

	private UserProfileTO setDummyProfile() {
		UserProfileTO profile1 = new UserProfileTO();
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
		profile1.setId(500L);
		return profile1;
	}
}
