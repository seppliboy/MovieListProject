package com.qa.movielist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.movielist.model.MovieList;
import com.qa.movielist.repo.Repo;

@Service
public class Services {
	
	private Repo repo;
	
	public Services(Repo repo) {
	super();
	this.repo = repo;
	}
	
	// Create movie
	public boolean createMovie(MovieList movie) {
			repo.save(movie);
			return true;
	}
		
	// Create preset movie (?)
		
	// Get by movie Id
	public MovieList getById(long id) {
		 return repo.findById(id).get();
	}
		
	// Get all movies
	public List<MovieList> getAllMovies() {
			return repo.findAll();
	}
		
	// Delete by Id
	public boolean deleteById(long id) {
		repo.deleteById(id);
		return true;
	}
		
	// Delete all movies 
	public boolean deleteAllMovies() {
		repo.deleteAll();
		return true;
	}
		
	// Update by Id
	public boolean updateById(long id, MovieList movie) {
		
		MovieList oldMovie = getById(id);
			
		oldMovie.setTitle(movie.getTitle());
		oldMovie.setGenre(movie.getGenre());
		oldMovie.setRunningTime(movie.getRunningTime());
		oldMovie.setReleaseYear(movie.getReleaseYear());
		oldMovie.setWatched(movie.isWatched());

		repo.save(oldMovie);
			
			return true;
		}
		
		// [CUSTOM QUERIES]
		
		// Show by title
//		public List<MovieList> getByTitle(String title) {
//			return repo.findByTitle(country);
//		}
		
		// Show by title ascending
		
		// Show by title descending
		
		//
			
		

}
