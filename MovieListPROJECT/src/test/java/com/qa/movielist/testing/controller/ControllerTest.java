package com.qa.movielist.testing.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.movielist.controller.Controller;
import com.qa.movielist.model.MovieList;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Sql(scripts = {"classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	MovieList testMovie1 = new MovieList("TestMovie1", "TestGenre1", 100, 1985, false);
	MovieList testMovie2 = new MovieList("TestMovie2", "TestGenre2", 80, 1965, false);
	MovieList testMovie3 = new MovieList("TestMovie3", "TestGenre4", 120, 2020, false);
	MovieList testMovie4 = new MovieList("TestMovie4", "TestGenre4", 90, 2005, false);
	MovieList testMovie5 = new MovieList("TestMovie5", "TestGenre5", 50, 1936, false);
	
	MovieList testMovie1Id = new MovieList(1, "TestMovie1", "TestGenre1", 100, 1985, false);
	MovieList testMovie2Id = new MovieList(2, "TestMovie2", "TestGenre2", 80, 1965, false);
	MovieList testMovie3Id = new MovieList(3, "TestMovie3", "TestGenre4", 120, 2020, false);
	MovieList testMovie4Id = new MovieList(4, "TestMovie4", "TestGenre4", 90, 2005, false);
	MovieList testMovie5Id = new MovieList(5, "TestMovie5", "TestGenre5", 50, 1936, false);
	
	
	@Test
	public void testCreate() throws Exception {
		
		//Arrange
		String movieToJson = mapper.writeValueAsString(testMovie1);
		RequestBuilder request = post("/createMovie").contentType(MediaType.APPLICATION_JSON).content(movieToJson);

		//Act
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().string("Movie added, ID number: 3");
		
		//Assert
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	public void testGetById() throws Exception {
		
		//Arrange
		String movieToJson = mapper.writeValueAsString(testMovie2Id);

		//Act
		RequestBuilder request = get("/getById/2");
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(movieToJson);
		
		//Assert
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testGetAll() throws Exception {
		
		//Arrange
		List<MovieList> movieList = List.of(testMovie1Id, testMovie2Id);
		
		String movieListToJson = mapper.writeValueAsString(movieList);
		
		//Act
		RequestBuilder request = get("/getAllMovies");
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(movieListToJson);
		
		//
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testDeleteById() throws Exception {
		
		//Arrange
		String movieToJson = mapper.writeValueAsString(testMovie3);
		RequestBuilder request = post("/createMovie").contentType(MediaType.APPLICATION_JSON).content(movieToJson);
		mvc.perform(request);
		
		//Act
		RequestBuilder request2 = get("/deleteById/3");
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("Booking ID 3 removed");
		
		//Assert
		mvc.perform(request2).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testDeleteAll() throws Exception {
		
		//Arrange
		// None
		
		//Act
		RequestBuilder request = get("/deleteAllMovies");
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("All Movies Removed!");
		
		//Assert
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void updateByIdTest() throws Exception {
		
		//Arrange
		MovieList movieToUpdate = new MovieList("Children Of Men", "Sci-Fi/Thriller", 109, 2006, true);
		String movieToUpdateToJson = mapper.writeValueAsString(movieToUpdate);

		//Act
		RequestBuilder request = put("/updateById/2").contentType(MediaType.APPLICATION_JSON).content(movieToUpdateToJson);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().string("Updated Movie Id: 2");
		
		//Assert
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	
	
	
	
	
}
