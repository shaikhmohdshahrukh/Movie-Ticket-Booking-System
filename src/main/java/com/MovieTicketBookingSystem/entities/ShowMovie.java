package com.MovieTicketBookingSystem.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;

@Entity
public class ShowMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "show_movie_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long showMovieId;

	private LocalDate date; // Date of the show
	
	private LocalTime time; // Time of the show

	private String venue; // Theater or cinema hall name
	
	private int availableSeats; // Number of available seats
	
	private double ticketPrice; // Ticket price for the show

	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "movieId") // Foreign key linking to the Movie entity
	private Movie movie;
	
	private Long userId;

	public ShowMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowMovie(Long showMovieId, LocalDate date, LocalTime time, String venue, int availableSeats,
			double ticketPrice, Movie movie) {
		super();
		this.showMovieId = showMovieId;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.availableSeats = availableSeats;
		this.ticketPrice = ticketPrice;
		this.movie = movie;
	}

	public ShowMovie(Long showMovieId, LocalDate date, LocalTime time, String venue, int availableSeats,
			double ticketPrice, Movie movie, Long userId) {
		super();
		this.showMovieId = showMovieId;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.availableSeats = availableSeats;
		this.ticketPrice = ticketPrice;
		this.movie = movie;
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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ShowMovie [showMovieId=" + showMovieId + ", date=" + date + ", time=" + time + ", venue=" + venue
				+ ", availableSeats=" + availableSeats + ", ticketPrice=" + ticketPrice + ", movie=" + movie
				+ ", userId=" + userId + "]";
	}
	
}
