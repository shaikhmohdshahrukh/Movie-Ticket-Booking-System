package com.MovieTicketBookingSystem.dtos;

import java.time.LocalDateTime;
import com.MovieTicketBookingSystem.entities.Booking;

public class BookingDto {

    private Long bookingId;

    private String seats; // Example: "A1, A2, B3"
    
    private double totalCost;
    
    private LocalDateTime bookingTime; // Timestamp of when the booking was made
    
    private String paymentStatus; // Example: "Pending", "Completed", "Failed"
    
    private String paymentMethod; // Example: "Credit Card", "UPI", "Cash"
    
    private String bookingStatus; // Example: "Confirmed", "Cancelled", "Pending"

    private Long showMovieId;
    
    private Long userId;
	
	
	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDto(Long bookingId, String seats, double totalCost, LocalDateTime bookingTime, String paymentStatus,
			String paymentMethod, String bookingStatus, Long showMovieId, Long userId) {
		super();
		this.bookingId = bookingId;
		this.seats = seats;
		this.totalCost = totalCost;
		this.bookingTime = bookingTime;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.bookingStatus = bookingStatus;
		this.showMovieId = showMovieId;
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

	public Long getShowMovieId() {
		return showMovieId;
	}

	public void setShowMovieId(Long showMovieId) {
		this.showMovieId = showMovieId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Booking getBooking() {
		// TODO Auto-generated method stub
		return new Booking(bookingId, seats, totalCost, bookingTime, paymentStatus, paymentMethod, bookingStatus, null, userId);
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", seats=" + seats + ", totalCost=" + totalCost + ", bookingTime="
				+ bookingTime + ", paymentStatus=" + paymentStatus + ", paymentMethod=" + paymentMethod
				+ ", bookingStatus=" + bookingStatus + ", showMovieId=" + showMovieId + ", userId=" + userId + "]";
	}

}
