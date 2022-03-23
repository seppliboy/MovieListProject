package com.qa.movielist.testing.services;

import static org.mockito.Mockito.mockitoSession;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.movielist.model.MovieList;
import com.qa.movielist.repo.Repo;
import com.qa.movielist.services.Services;

@SpringBootTest
//@ActiveProfiles("test")
public class ServicesTest {

	@MockBean
	private Repo repo;
	
	@Autowired
	private Services service;
	
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
	public void testCreateMovie() {
		
		//Arrange
		Mockito.when(repo.save(testMovie1)).thenReturn(testMovie1Id);
		
		//Act
		boolean result = service.createMovie(testMovie1);
		
		//Assert
		Assertions.assertTrue(result);
		
		Mockito.verify(repo,Mockito.times(1)).save(testMovie1);
	}
	
	@Test
	public void testGetById() {
		
		//Arrange
		Mockito.when(repo.findById(1l)).thenReturn(Optional.of(testMovie1Id));
		
		//Act
		MovieList movie = service.getById(1l);
		
		//Assert
		Assertions.assertEquals(movie, testMovie1Id);
		
		Mockito.verify(repo, Mockito.never()).count();
	}
	
	@Test
	public void testGetAllMovies() throws Exception {
		
		//Arrange
		List<MovieList> testMovieList = List.of(testMovie1Id, testMovie2Id);
		Mockito.when(repo.findAll()).thenReturn(testMovieList);
		
		//Act
		List<MovieList> result = service.getAllMovies();
		
		//Assert
		Assertions.assertEquals(testMovieList, result);
	}
	
	@Test
	public void testUpdateById() throws Exception {
		
		//Arrange
		MovieList updatedMovie = new MovieList("TestMovie3", "TestGenre4", 120, 2020, false);
		Mockito.when(repo.findById(1l)).thenReturn(Optional.of(testMovie1));
		Mockito.when(repo.save(testMovie1Id)).thenReturn(updatedMovie);
		
		//Act
		boolean result = service.updateById(1l, updatedMovie);
		
		//Assert
		Assertions.assertTrue(result);
	}
	
	@Test public void testDeleteById() throws Exception {
		
		//Arrange
		Mockito.when(repo.findById(2l)).thenReturn(Optional.of(testMovie2));
		
		//Act
		boolean result = service.deleteById(2l);
		
		//Assert
		
		Assertions.assertTrue(result);
		
		Mockito.verify(repo, Mockito.atLeastOnce()).deleteById(2l);
	}
	
	@Test public void testDeleteAll() throws Exception {
		
		//Arrange
		Mockito.when(repo.findById(2l)).thenReturn(Optional.of(testMovie2));
		
		//Act
		boolean result = service.deleteAllMovies();
		
		//Assert		
		Assertions.assertTrue(result);
		
		Mockito.verify(repo, Mockito.atLeastOnce()).deleteAll();
	}
	
	
	
	
}
