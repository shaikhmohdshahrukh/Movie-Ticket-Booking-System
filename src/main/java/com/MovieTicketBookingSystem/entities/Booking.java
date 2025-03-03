package com.MovieTicketBookingSystem.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;

@Entity
public class Booking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "booking_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
    private Long bookingId;

    private String seats; // Example: "A1, A2, B3"
    
    private double totalCost;
    
    private LocalDateTime bookingTime; // Timestamp of when the booking was made
    
    private String paymentStatus; // Example: "Pending", "Completed", "Failed"
    
    private String paymentMethod; // Example: "Credit Card", "UPI", "Cash"
    
    private String bookingStatus; // Example: "Confirmed", "Cancelled", "Pending"

    @ManyToOne
    @JoinColumn(name = "show_movie_id", referencedColumnName = "showMovieId") // Foreign key linking to the Show entity
    private ShowMovie showMovie;
    
    private Long userId;
    
    // Default constructor
    public Booking() {
    	
    }

	public Booking(Long bookingId, String seats, double totalCost, LocalDateTime bookingTime, String paymentStatus,
			String paymentMethod, String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.seats = seats;
		this.totalCost = totalCost;
		this.bookingTime = bookingTime;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.bookingStatus = bookingStatus;
	}

	public Booking(Long bookingId, String seats, double totalCost, LocalDateTime bookingTime, String paymentStatus,
			String paymentMethod, String bookingStatus, ShowMovie showMovie, Long userId) {
		super();
		this.bookingId = bookingId;
		this.seats = seats;
		this.totalCost = totalCost;
		this.bookingTime = bookingTime;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.bookingStatus = bookingStatus;
		this.showMovie = showMovie;
		this.userId = userId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public ShowMovie getShowMovie() {
		return showMovie;
	}

	public void setShowMovie(ShowMovie showMovie) {
		this.showMovie = showMovie;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", seats=" + seats + ", totalCost=" + totalCost + ", bookingTime="
				+ bookingTime + ", paymentStatus=" + paymentStatus + ", paymentMethod=" + paymentMethod
				+ ", bookingStatus=" + bookingStatus + ", showMovie=" + showMovie + ", userId=" + userId + "]";
	}


}
