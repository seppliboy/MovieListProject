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
	
	@GetMapping("/getByTitleAsc")
	public ResponseEntity<List<MovieList>> getByTitleAsc() {
		List<MovieList> response = service.getByTitleAsc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByTitleDesc")
	public ResponseEntity<List<MovieList>> getByTitleDesc() {
		List<MovieList> response = service.getByTitleDesc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	// Get by genre
	
	@GetMapping("/getByGenre/{genre}")
	public ResponseEntity<List<MovieList>> getByGenre(@PathVariable("genre") String genre) {
		List<MovieList> response = service.getByGenre(genre);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByGenreAsc")
	public ResponseEntity<List<MovieList>> getByGenreAsc() {
		List<MovieList> response = service.getByGenreAsc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByGenreDesc")
	public ResponseEntity<List<MovieList>> getByGenreDesc() {
		List<MovieList> response = service.getByGenreDesc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	// Get by running time
	
	@GetMapping("/getByRunningTime/{runningTime}")
	public ResponseEntity<List<MovieList>> getByRunningTime(@PathVariable("runningTime") int runningTime) {
		List<MovieList> response = service.getByRunningTime(runningTime);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByRunningTimeAsc")
	public ResponseEntity<List<MovieList>> getByRunningTimeAsc() {
		List<MovieList> response = service.getByRunningTimeAsc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByRunningTimeDesc")
	public ResponseEntity<List<MovieList>> getByRunningTimeDesc() {
		List<MovieList> response = service.getByRunningTimeDesc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByRunningTimeGreaterThan/{runningTime}")
	public ResponseEntity<List<MovieList>> getByRunningTimeGreaterThan(@PathVariable("runningTime") int runningTime) {
		List<MovieList> response = service.getByRunningTimeGreaterThan(runningTime);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByRunningTimeLessThan/{runningTime}")
	public ResponseEntity<List<MovieList>> getByRunningTimeLessThan(@PathVariable("runningTime") int runningTime) {
		List<MovieList> response = service.getByRunningTimeLessThan(runningTime);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	// Get by release year
	
	@GetMapping("/getByReleaseYear/{releaseYear}")
	public ResponseEntity<List<MovieList>> getByReleaseYear(@PathVariable("releaseYear") int releaseYear) {
		List<MovieList> response = service.getByReleaseYear(releaseYear);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByReleaseYearAsc")
	public ResponseEntity<List<MovieList>> getByReleaseYearAsc() {
		List<MovieList> response = service.getByReleaseYearAsc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByReleaseYearDesc")
	public ResponseEntity<List<MovieList>> getByReleaseYearDesc() {
		List<MovieList> response = service.getByReleaseYearDesc();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByReleaseYearGreaterThan/{releaseYear}")
	public ResponseEntity<List<MovieList>> getByReleaseYearGreaterThan(@PathVariable("releaseYear") int releaseYear) {
		List<MovieList> response = service.getByReleaseYearGreaterThan(releaseYear);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getByReleaseYearLessThan/{releaseYear}")
	public ResponseEntity<List<MovieList>> getByReleaseYearLessThan(@PathVariable("releaseYear") int releaseYear) {
		List<MovieList> response = service.getByReleaseYearLessThan(releaseYear);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	// Get by watched
	
	@GetMapping("/getByWatched/{watched}")
	public ResponseEntity<List<MovieList>> getByWatched(@PathVariable("watched") boolean watched) {
		List<MovieList> response = service.getByWatched(watched);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
}
