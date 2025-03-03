package com.MovieTicketBookingSystem.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.MovieTicketBookingSystem.entities.Booking;

public interface BookingService {
	
	public Booking createBooking(Booking booking);

	public Optional<Booking> getBookingById(Long id);
	
	public List<Booking> getAllBooking();
	
	public Booking updateBooking(Booking booking);
	
	public void deleteByBookingId(Long id);
	
	public List<String> getAllBookingUniqueSeats();
	
	public Long getBookingCountTotal();
	
	public List<Booking> getBookingPaymentStatusCheck();
	
	public List<Booking> getBookingPaymentMethodCheck();
	
	public List<Booking> getBookingStatus();
	
	public List<Booking> getBookingTotalCostAscendingOrder();
	
	public List<Booking> getBookingTotalCostGreaterThan60000();
	
	public Map<String, Long> getBookingCountBySeats();
	
	public List<Booking> getBookingPaymentStatusCompleted();
	
	public Map<String, Long> getBookingCountByPaymentStatus();
}
