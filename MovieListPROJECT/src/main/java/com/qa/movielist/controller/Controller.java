package com.qa.movielist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.movielist.model.MovieList;
import com.qa.movielist.services.Services;

@RestController
public class Controller {

	private Services service;
	
	
	public Controller(Services service){
		super();
		this.service = service;
	}
	
	// Create movie 
	@PostMapping("/createMovie") 
	public ResponseEntity<String> createMovie(@RequestBody MovieList movie) {
		boolean checkMethod = service.createMovie(movie);  // unused variable(?)
		ResponseEntity<String> response = new ResponseEntity<String>("Movie added, ID number: " + movie.getId(), HttpStatus.CREATED);
		return response;
	}
	
	// Get by Id
	@GetMapping("/getById/{id}")
	public ResponseEntity<MovieList> getbyId(@PathVariable("id") int id) {
		MovieList result = service.getById(id);
		ResponseEntity<MovieList> response = new ResponseEntity<MovieList>(result, HttpStatus.ACCEPTED);
		return response;
	}
	
	// Get all
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<MovieList>> getAllMovies() {
		List<MovieList> result = service.getAllMovies();
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	// Delete by Id
	@GetMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		service.deleteById(id);
		ResponseEntity<String> response = new ResponseEntity<String>("Booking ID " + id + " removed", HttpStatus.ACCEPTED);
		return response;
	}
	
	// Delete all
	@GetMapping("/deleteAllMovies")
	public ResponseEntity<String> deleteAllMovies() {
		service.deleteAllMovies();
		ResponseEntity<String> response = new ResponseEntity<String>("All Movies Removed!", HttpStatus.ACCEPTED);
		return response;
	}
	
	// Update by Id
	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> update(@PathVariable("id")int id, @RequestBody MovieList movie) {
		service.updateById(id, movie);
		ResponseEntity<String> response = new ResponseEntity<String>("Updated Movie Id: " + id, HttpStatus.OK);
		return response;
	}
	
	// Custom queries
	
	// Get by title
	
	@GetMapping("getByTitle/{title}")
	public ResponseEntity<List<MovieList>> getByTitle(@PathVariable("title") String title) {
		List<MovieList> response = service.getByTitle(title);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
		
	
	
}
