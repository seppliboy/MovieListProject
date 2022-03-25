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
		public List<MovieList> getByTitle(String title) {
			return repo.findByTitle(title);
		}
		
		// Show by title ascending
		public List<MovieList> getByTitleAsc() {
			return repo.findByOrderByTitleAsc();
		}
		
		// Show by title descending
		public List<MovieList> getByTitleDesc() {
			return repo.findByOrderByTitleDesc();
		}
		
		// Show by genre
		public List<MovieList> getByGenre(String title) {
			return repo.findByGenre(title);
		}
		
		// Show by genre ascending
		public List<MovieList> getByGenreAsc() {
			return repo.findByOrderByGenreAsc();
		}
		
		// Show by genre descending
		public List<MovieList> getByGenreDesc() {
			return repo.findByOrderByGenreDesc();
		}
		
		// Show by running time
		public List<MovieList> getByRunningTime(int runningTime) {
			return repo.findByRunningTime(runningTime);
		}
		
		// Show by running time ascending
		public List<MovieList> getByRunningTimeAsc() {
			return repo.findByOrderByRunningTimeAsc();
		}
		
		// Show by running time descending
		public List<MovieList> getByRunningTimeDesc() {
			return repo.findByOrderByRunningTimeDesc();
		}
		
		// Show by running time greater than
		public List<MovieList> getByRunningTimeGreaterThan(int runningTime) {
			return repo.findByRunningTimeGreaterThan(runningTime);
		}
		
		// Show by running time less than
		public List<MovieList> getByRunningTimeLessThan(int runningTime) {
			return repo.findByRunningTimeLessThan(runningTime);
		}
		
		// Show by release year
		public List<MovieList> getByReleaseYear(int releaseYear) {
			return repo.findByReleaseYear(releaseYear);
		}
		
		// Show by release year ascending
		public List<MovieList> getByReleaseYearAsc() {
			return repo.findByOrderByReleaseYearAsc();
		}
		
		// Show by release year descending
		public List<MovieList> getByReleaseYearDesc() {
			return repo.findByOrderByReleaseYearDesc();
		}
		
		// Show by release year greater than
		public List<MovieList> getByReleaseYearGreaterThan(int releaseYear) {
			return repo.findByReleaseYearGreaterThan(releaseYear);
		}
		
		// Show by release year less than
		public List<MovieList> getByReleaseYearLessThan(int releaseYear) {
			return repo.findByReleaseYearLessThan(releaseYear);
		}
		
		// Show by watched
		public List<MovieList> getByWatched(boolean watched) {
			return repo.findByWatched(watched);
		}
}
