package com.MovieTicketBookingSystem.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MovieTicketBookingSystem.daos.MovieDao;
import com.MovieTicketBookingSystem.entities.Movie;
import com.MovieTicketBookingSystem.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	public MovieDao movieRepo;
	
	
	@Override
	public Movie createMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}

	@Override
	public Optional<Movie> getMovieById(Long id) {
		// TODO Auto-generated method stub
		return movieRepo.findById(id);
	}

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}

	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}

	@Override
	public void deleteMovieById(Long id) {
		// TODO Auto-generated method stub
		movieRepo.deleteById(id);
	}

	@Override
	public List<String> getMovieByTital(String title) {
		// TODO Auto-generated method stub
		return movieRepo.findAll().stream().map(Movie::getTitle)
				.distinct().collect(Collectors.toList());
	}

	@Override
	public List<String> getMovieByDirector(String director) {
		// TODO Auto-generated method stub
		return movieRepo.findAll().stream().map(Movie::getDirector)
				.distinct().collect(Collectors.toList());
	}

	@Override
	public long getMovieDirectorCount() {
		// TODO Auto-generated method stub
		return movieRepo.findAll().stream().count();
	}

	@Override
	public List<Movie> getMovieTitleByStartingWith() {
		// TODO Auto-generated method stub
		return movieRepo.findAll().stream().filter(Movie -> Movie.getDirector()
				.startsWith("M")).toList();
	}

	@Override
	public List<Movie> getMovieReleaseYear() {
		// TODO Auto-generated method stub
		return movieRepo.findAll().stream().filter(Movie -> Movie.getReleaseYear()
				> 2024).toList();
	}

	@Override
	public List<Movie> getMovieHindiLanguage() {
		// TODO Auto-generated method stub
		return movieRepo.findAll().stream().filter(Movie -> Movie.getLanguage()
				.startsWith("Hindi")).toList();
	}
}
