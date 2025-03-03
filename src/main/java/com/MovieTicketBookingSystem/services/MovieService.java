package com.MovieTicketBookingSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.MovieTicketBookingSystem.entities.Movie;

public interface MovieService {
	
	public Movie createMovie(Movie movie);
	public  Optional<Movie> getMovieById(Long id);
	public List<Movie> getAllMovie();
	public Movie updateMovie(Movie movie);
	public void deleteMovieById(Long id);
	
	public List<String> getMovieByTital(String title);
	
	public List<String> getMovieByDirector(String director);
	
	public long getMovieDirectorCount();
	 
	@Query(value = "SELECT * FROM movie WHERE director LIKE 'M%'")
	public List<Movie> getMovieTitleByStartingWith();
	
	@Query(value = "SELECT * FROM movie WHERE release_year > 2023")
	public List<Movie> getMovieReleaseYear();
	
	public List<Movie> getMovieHindiLanguage();
}
