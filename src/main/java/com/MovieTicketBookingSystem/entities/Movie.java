package com.MovieTicketBookingSystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "movie_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long movieId;

	private String title;
	
	private String genre;
	
	private int duration; // Duration in minutes

	private String director; // Director's name
	
	private double rating; // IMDB or custom rating (e.g., 7.5)
	
	private int releaseYear; // Year of release
	
	private String language; // Language of the movie

	private Long userId;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Long movieId, String title, String genre, int duration, String director, double rating,
			int releaseYear, String language) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.director = director;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.language = language;
	}

	public Movie(Long movieId, String title, String genre, int duration, String director, double rating,
			int releaseYear, String language, Long userId) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.director = director;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.language = language;
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", duration=" + duration
				+ ", director=" + director + ", rating=" + rating + ", releaseYear=" + releaseYear + ", language="
				+ language + ", userId=" + userId + "]";
	}

}
