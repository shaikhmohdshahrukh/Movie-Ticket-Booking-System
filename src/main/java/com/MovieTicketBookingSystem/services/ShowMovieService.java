package com.MovieTicketBookingSystem.services;

import java.util.List;
import java.util.Optional;

import com.MovieTicketBookingSystem.entities.ShowMovie;

public interface ShowMovieService {

	public ShowMovie createShowMovie(ShowMovie showMovie);
	public Optional<ShowMovie> getShowMovieById(Long id);
	public List<ShowMovie> getAllShowMovie();
	public ShowMovie updateShowMovie(ShowMovie showMovie);
	public void deleteByShowMovieId(Long id);
	
	public List<String> getShowMovieCinemaHall();
	
	public List<ShowMovie> getShowMovieOnlyCinema();
	
	public long getShowMovieCount();
	
	public List<ShowMovie> getShowMovieTicketPrice();
	
	public Optional<ShowMovie> getShowMovieTicketPriceByAscendingOrder();
}
