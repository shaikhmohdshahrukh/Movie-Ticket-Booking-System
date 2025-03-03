package com.MovieTicketBookingSystem.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.MovieTicketBookingSystem.dtos.ShowMovieDto;
import com.MovieTicketBookingSystem.entities.Movie;
import com.MovieTicketBookingSystem.entities.ShowMovie;
import com.MovieTicketBookingSystem.services.MovieService;
import com.MovieTicketBookingSystem.services.ShowMovieService;


@RestController
public class ShowMovieController {

	@Autowired
	public ShowMovieService showMovieService;
	
	@Autowired
	public MovieService movieService;
	
	@GetMapping("/showMovies")
	public List<ShowMovie> getAllShowMovie(){
		return showMovieService.getAllShowMovie();
	}
	
	@GetMapping("/showMovies/{showMovieId}")
	public ResponseEntity<?> getByShowMovieId(@PathVariable Long id){
		Optional<ShowMovie> optionalShow = showMovieService.getShowMovieById(id);
		if(optionalShow.isPresent()) {
			return new ResponseEntity<ShowMovie>(optionalShow.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("ShowMovie Not Found ",HttpStatus.NOT_FOUND);
		}
	}

//	@PostMapping("/showMovies")
//	public ResponseEntity<?> createShowMovie(@RequestBody ShowMovie showMovie){
//		showMovieService.createShowMovie(showMovie);
//		return new ResponseEntity<String>("ShowMovie created Successfuloly ",HttpStatus.CREATED);
//	}
	

	@PostMapping("/showMovies")
	public ResponseEntity<?> createShowMovie(@RequestBody ShowMovieDto showMovieDto){
		ShowMovie showMovie = showMovieDto.getShowMovie();
		Optional<Movie> movie = movieService.getMovieById(showMovieDto.getMovieId());
		showMovie.setMovie(movie.get());
		showMovieService.createShowMovie(showMovie);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/showMovies/{showMovieId}")
	public ResponseEntity<?> deleteByShowMovieId(@PathVariable Long showMovieId) {
		showMovieService.deleteByShowMovieId(showMovieId);
		return new ResponseEntity<String>("ShowMovie Deleted Successfully", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/showMovies/{showMovieId}")
	public ResponseEntity<?> updateShowMovie(@RequestBody ShowMovie showMovie){
		showMovie = showMovieService.updateShowMovie(showMovie);
		return new ResponseEntity<String>("ShowMovie Updated Successfully",HttpStatus.OK);
	}	
	
	@GetMapping("/showMovies/cinema-hall")
	public ResponseEntity<?> getShowMovieCinemaHall(){
		return ResponseEntity.ok(showMovieService.getShowMovieCinemaHall());
	}
	
	@GetMapping("/showMovies/start-cinema")
	public ResponseEntity<?> getShowMovieOnlyCinema(){
		return ResponseEntity.ok(showMovieService.getShowMovieOnlyCinema());
	}
	
	@GetMapping("/showMovies/count-show-movie")
	public ResponseEntity<?> getShowMovieCount(){
		return ResponseEntity.ok(showMovieService.getShowMovieCount());
	}
	
	@GetMapping("/showMovies/show-movie-ticket-price")
	public ResponseEntity<?> getShowMovieTicketPrice(){
		return ResponseEntity.ok(showMovieService.getShowMovieTicketPrice());
	}
	
	@GetMapping("/showMovies/ticket-price-by-ascending-order")
	public ResponseEntity<?> getShowMovieTicketPriceByAscendingOrder(){
		return ResponseEntity.ok(showMovieService.getShowMovieTicketPriceByAscendingOrder());
	}
}
