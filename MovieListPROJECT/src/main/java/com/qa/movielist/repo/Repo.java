package com.qa.movielist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.qa.movielist.model.MovieList;

public interface Repo extends JpaRepository<MovieList, Long> {

	// Title
	public List<MovieList> findByTitle(String title); 
	public List<MovieList> findByOrderByTitleAsc();
	public List<MovieList> findByOrderByTitleDesc();
		
	// Genre
	public List<MovieList> findByGenre(String genre);
	public List<MovieList> findByOrderByGenreAsc();	
	public List<MovieList> findByOrderByGenreDesc();	
		
	// Running Time
	public List<MovieList> findByRunningTime(int runningTime);
	public List<MovieList> findByOrderByRunningTimeAsc();	
	public List<MovieList> findByOrderByRunningTimeDesc();	
	public List<MovieList> findByRunningTimeGreaterThan(int runningTime);
	public List<MovieList> findByRunningTimeLessThan(int runningTime);	

	// Release Year
	public List<MovieList> findByReleaseYear(int releaseYear);
	public List<MovieList> findByOrderByReleaseYearAsc();	
	public List<MovieList> findByOrderByReleaseYearDesc();	
	public List<MovieList> findByReleaseYearGreaterThan(int releaseYear);	 
	public List<MovieList> findByReleaseYearLessThan(int releaseYear);	

	// Watched
	public List<MovieList> findByWatched(boolean watched);
	public List<MovieList> findByOrderByWatchedAsc();
	public List<MovieList> findByOrderByWatchedDesc();
	
	
//	public List<MovieList> findByOrderByRunningTimeGreaterThanAsc(int runningTime);	(?)
//	public List<MovieList> findByRunningTimeGreaterThanDesc(int runningTime);	 (?)
//
//	public List<MovieList> findByReleaseYearGreaterThanAsc(int releaseYear);	 (?)
//	public List<MovieList> findByReleaseYearGreaterThanDesc(int releaseYear);	 (?)
	
//	public List<MovieList> findByRunningTimeLessThanAsc(int runningTime);	
//	public List<MovieList> findByRunningTimeLessThanDesc(int runningTime);	
//	
//	public List<MovieList> findByReleaseYearLessThanAsc(int releaseYear);	
//	public List<MovieList> findByReleaseYearLessThanDesc(int releaseYear);		

}
