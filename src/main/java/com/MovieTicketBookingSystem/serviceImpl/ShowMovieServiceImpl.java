package com.MovieTicketBookingSystem.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MovieTicketBookingSystem.daos.ShowMovieDao;
import com.MovieTicketBookingSystem.entities.ShowMovie;
import com.MovieTicketBookingSystem.services.ShowMovieService;

@Service
public class ShowMovieServiceImpl implements ShowMovieService{

	@Autowired
	public ShowMovieDao showRepo;
	
	@Override
	public ShowMovie createShowMovie(ShowMovie showMovie) {
		return showRepo.save(showMovie);
	}

	@Override
	public Optional<ShowMovie> getShowMovieById(Long id) {
		return showRepo.findById(id);
	}

	@Override
	public List<ShowMovie> getAllShowMovie() {
		return showRepo.findAll();
	}

	@Override
	public ShowMovie updateShowMovie(ShowMovie showMovie) {
		return showRepo.save(showMovie);
	}

	@Override
	public void deleteByShowMovieId(Long id) {
		showRepo.deleteById(id);
	}

	@Override
	public List<String> getShowMovieCinemaHall() {
		return showRepo.findAll().stream().map(ShowMovie::getVenue)
				.distinct().collect(Collectors.toList());
	}

	@Override
	public List<ShowMovie> getShowMovieOnlyCinema() {
		return showRepo.findAll().stream().filter(ShowMovie -> ShowMovie.getVenue()
				.startsWith("C")).toList();
	}

	@Override
	public long getShowMovieCount() {
		return showRepo.findAll().stream().count();
	}

	@Override
	public List<ShowMovie> getShowMovieTicketPrice() {
		return showRepo.findAll().stream().filter(ShowMovie -> ShowMovie.getTicketPrice()
				> 520).toList();
	}

	@Override
	public Optional<ShowMovie> getShowMovieTicketPriceByAscendingOrder() {
		return showRepo.findAll().stream()
				.max(Comparator.comparing(ShowMovie::getTicketPrice));
	}

}
