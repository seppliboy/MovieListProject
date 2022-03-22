package com.qa.movielist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.qa.movielist.model.MovieList;

public interface Repo extends JpaRepository<MovieList, Long> {

//	// Title
//	public List<MovieList> findByTitle(String title);
//	public List<MovieList> findByTitleAsc(String title);
//	public List<MovieList> findByTitleDesc(String title);
//		
//	// Genre
//	public List<MovieList> findByGenre(String genre);
//	public List<MovieList> findByGenreAsc(String genre);	
//	public List<MovieList> findByGenreDesc(String genre);	
//		
//	// Running Time
//	public List<MovieList> findByRunningTime(int runningTime);
//	public List<MovieList> findByRunningTimeAsc(int runningTime);	
//	public List<MovieList> findByRunningTimeDesc(int runningTime);	
//	public List<MovieList> findByRunningTimeGreaterThan(int runningTime);
//
//	public List<MovieList> findByRunningTimeLessThan(int runningTime);	
//
//	// Release Year
//	public List<MovieList> findByReleaseYear(int releaseYear);
//	public List<MovieList> findByReleaseYearAsc(int releaseYear);	
//	public List<MovieList> findByReleaseYearDesc(int releaseYear);	
//	public List<MovieList> findByReleaseYearGreaterThan(int releaseYear);	
//
//	public List<MovieList> findByReleaseYearLessThan(int releaseYear);	
//
//		
//	// Watched
//	public List<MovieList> findByWatched(boolean watched);
//	public List<MovieList> findByWatchedAsc(boolean watched);
//	public List<MovieList> findByWatchedDesc(boolean watched);
	
	
//	public List<MovieList> findByRunningTimeGreaterThanAsc(int runningTime);	(?)
//	public List<MovieList> findByRunningTimeGreaterThanDesc(int runningTime);	 (?)

//	public List<MovieList> findByReleaseYearGreaterThanAsc(int releaseYear);	 (?)
//	public List<MovieList> findByReleaseYearGreaterThanDesc(int releaseYear);	 (?)
	
//	public List<MovieList> findByRunningTimeLessThanAsc(int runningTime);	
//	public List<MovieList> findByRunningTimeLessThanDesc(int runningTime);	
	
//	public List<MovieList> findByReleaseYearLessThanAsc(int releaseYear);	
//	public List<MovieList> findByReleaseYearLessThanDesc(int releaseYear);		

		
		

	
}
