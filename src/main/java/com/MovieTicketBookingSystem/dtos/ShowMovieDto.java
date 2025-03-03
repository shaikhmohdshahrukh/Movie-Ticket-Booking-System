package com.MovieTicketBookingSystem.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import com.MovieTicketBookingSystem.entities.ShowMovie;


public class ShowMovieDto {
	
	private Long showMovieId;

	private LocalDate date; // Date of the show
	
	private LocalTime time; // Time of the show

	private String venue; // Theater or cinema hall name
	
	private int availableSeats; // Number of available seats
	
	private double ticketPrice; // Ticket price for the show
	
	private Long movieId;
	
	private Long userId;
		

	public ShowMovieDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowMovieDto(Long showMovieId, LocalDate date, LocalTime time, String venue, int availableSeats,
			double ticketPrice, Long movieId, Long userId) {
		super();
		this.showMovieId = showMovieId;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.availableSeats = availableSeats;
		this.ticketPrice = ticketPrice;
		this.movieId = movieId;
		this.userId = userId;
	}



	public Long getShowMovieId() {
		return showMovieId;
	}


	public void setShowMovieId(Long showMovieId) {
		this.showMovieId = showMovieId;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public String getVenue() {
		return venue;
	}


	public void setVenue(String venue) {
		this.venue = venue;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	public double getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	public Long getMovieId() {
		return movieId;
	}


	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public ShowMovie getShowMovie() {
		
		return new ShowMovie(showMovieId, date, time, venue, availableSeats, ticketPrice, null, userId);
	}


	@Override
	public String toString() {
		return "ShowMovieDto [showMovieId=" + showMovieId + ", date=" + date + ", time=" + time + ", venue=" + venue
				+ ", availableSeats=" + availableSeats + ", ticketPrice=" + ticketPrice + ", movieId=" + movieId
				+ ", userId=" + userId + "]";
	}

}
