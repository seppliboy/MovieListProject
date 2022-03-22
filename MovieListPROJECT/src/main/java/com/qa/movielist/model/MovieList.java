package com.qa.movielist.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 30)
	private String title;
	@Column(nullable = false, length = 30)
	private String genre;
	@Column(nullable = false)
	private int runningTime;
	@Column(nullable = false)
	private int releaseYear;
	@Column(nullable = false, length = 30)
	private boolean watched;
	
	// Constructor WITH Id
	public MovieList(long id, String title, String genre, int runningTime, int releaseYear, boolean watched) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.runningTime = runningTime;
		this.releaseYear = releaseYear;
		this.watched = watched;
	}

	// Constructor WITHOUT Id
	public MovieList(String title, String genre, int runningTime, int releaseYear, boolean watched) {
		super();
		this.title = title;
		this.genre = genre;
		this.runningTime = runningTime;
		this.releaseYear = releaseYear;
		this.watched = watched;
	}

	// Super Constructor
	public MovieList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public boolean isWatched() {
		return watched;
	}

	public void setWatched(boolean watched) {
		this.watched = watched;
	}

	//Hash Code and Equals 
	@Override
	public int hashCode() {
		return Objects.hash(genre, id, releaseYear, runningTime, title, watched);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieList other = (MovieList) obj;
		return Objects.equals(genre, other.genre) && id == other.id && releaseYear == other.releaseYear
				&& runningTime == other.runningTime && Objects.equals(title, other.title) && watched == other.watched;
	}

	
	//To String
	@Override
	public String toString() {
		return "MovieList [id=" + id + ", title=" + title + ", genre=" + genre + ", runningTime=" + runningTime
				+ ", releaseYear=" + releaseYear + ", watched=" + watched + "]";
	}
	
	
	

	
	
	
	
	
}
