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
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.capgemini.chess.dataaccess.objects.UserProfileDAO;
import com.capgemini.chess.tos.UserProfileTO;

@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UserProfileDAO userDAO;
	@InjectMocks
	private ProfileController profileController;
	
	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(profileController).setViewResolvers(viewResolver).build();
	}
	
	@Test
	//TODO how to distinguish delete and get if they both return a json object
	public void testDeleteProfile() throws Exception {
		//given
		String jsonUser = "{\"id\":500,\"name\":\"Mark\",\"surname\":\"Smith\",\"email\":\"email@correct.pl\",\"aboutMe\":\"Something\",\"lifeMotto\":\"dont worry\"}";
		UserProfileTO profile1 = new UserProfileTO();
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
		profile1.setId(500L);
		Mockito.when(userDAO.delete(500L)).thenReturn(profile1);
		//when
		ResultActions resultActions = mockMvc.perform(delete("/profile").param("id", "500"));
		//then
		resultActions.andExpect(content().json(jsonUser));
	}

	@Test
	public void shouldGetUserProfile() throws Exception {
		// given
		String jsonUser = "{\"id\":500,\"name\":\"Mark\",\"surname\":\"Smith\",\"email\":\"email@correct.pl\",\"aboutMe\":\"Something\",\"lifeMotto\":\"dont worry\"}";
		UserProfileTO profile1 = new UserProfileTO();
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
		profile1.setId(500L);
		Mockito.when(userDAO.readProfile(3L)).thenReturn(profile1);
		//when
		ResultActions resultActions = mockMvc.perform(get("/profile").param("id", "3"));
		//then
		resultActions.andExpect(content().json(jsonUser));
	}

	@Test
	public void testUpdateProfile() throws Exception {
		// given
		String jsonUser = "{\"id\":500,\"name\":\"Mark\",\"surname\":\"Smith\",\"email\":\"email@correct.pl\",\"aboutMe\":\"Something\",\"lifeMotto\":\"dont worry\"}";
		UserProfileTO profile1 = new UserProfileTO();
		profile1.setAboutMe("Something");
		profile1.setEmail("email@correct.pl");
		profile1.setLifeMotto("dont worry");
		profile1.setName("Mark");
		profile1.setSurname("Smith");
		profile1.setId(500L);
		Mockito.when(userDAO.update(Mockito.any(UserProfileTO.class))).thenReturn(profile1);
		//when
		ResultActions resultActions = mockMvc.perform(post("/profile").contentType(MediaType.APPLICATION_JSON)
				.content(jsonUser));
		//then
		resultActions.andExpect(content().json(jsonUser));
	}

}
