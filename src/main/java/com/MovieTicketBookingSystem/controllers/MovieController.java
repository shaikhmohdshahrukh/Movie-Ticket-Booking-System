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
import com.MovieTicketBookingSystem.entities.Movie;
import com.MovieTicketBookingSystem.services.MovieService;


@RestController
public class MovieController {

	@Autowired
	public MovieService movieService;

	@PostMapping("/movies")
	public ResponseEntity<?> createMovie(@RequestBody Movie movie) {
		movieService.createMovie(movie);
		return new ResponseEntity<String>("Movie Created Successfully ", HttpStatus.CREATED);
	}

	@GetMapping("/movies")
	public List<Movie> getAllMovie() {
		return movieService.getAllMovie();
	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<?> getByMovieId(@PathVariable Long movieId) {
		Optional<Movie> optionalMovie = movieService.getMovieById(movieId);
		if (optionalMovie.isPresent())
			return new ResponseEntity<Movie>(optionalMovie.get(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Movie Not Found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/movies/{movieId}")
	public ResponseEntity<?> deleteByMovieId(@PathVariable Long movieId) {
		movieService.deleteMovieById(movieId);
		return new ResponseEntity<String>("Movie Deleted Successfully", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/movies/{movieId}")
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
		movie = movieService.updateMovie(movie);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	} 	
	
	@GetMapping("/movies/title/{title}")
	public ResponseEntity<?> getMovieByTitle(@PathVariable String title){
		return ResponseEntity.ok(movieService.getMovieByTital(title));
	}
	
	@GetMapping("movies/director/{director}")
	public ResponseEntity<?> getMovieByDirector(@PathVariable String director){
		return ResponseEntity.ok(movieService.getMovieByDirector(director));
	}
	
	@GetMapping("/movies/director-count")
	public ResponseEntity<?> getMovieDirectorCount(){
		return ResponseEntity.ok(movieService.getMovieDirectorCount());
	}
	
	@GetMapping("/movies/title-start-with-M")
	public ResponseEntity<?> getMovieTitleStartingWith(){
		return ResponseEntity.ok(movieService.getMovieTitleByStartingWith());
	}
	
	@GetMapping("/movies/release-Year")
	public ResponseEntity<?> getMovieReleaseYear(){
		return ResponseEntity.ok(movieService.getMovieReleaseYear());
	}
	
	@GetMapping("/movies/hindi-language")
	public ResponseEntity<?> getMovieHindiLanguage(){
		return ResponseEntity.ok(movieService.getMovieHindiLanguage());
	}
	
}
