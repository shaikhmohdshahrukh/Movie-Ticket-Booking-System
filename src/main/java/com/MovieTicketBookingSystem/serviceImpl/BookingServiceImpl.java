package com.MovieTicketBookingSystem.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MovieTicketBookingSystem.daos.BookingDao;
import com.MovieTicketBookingSystem.entities.Booking;
import com.MovieTicketBookingSystem.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	public BookingDao bookingRepo;
	
	
	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepo.save(booking);
	}

	@Override
	public Optional<Booking> getBookingById(Long id) {
		// TODO Auto-generated method stub
		return bookingRepo.findById(id);
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll();
	}

	@Override
	public Booking updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepo.save(booking);
	}

	@Override
	public void deleteByBookingId(Long id) {
		// TODO Auto-generated method stub
		bookingRepo.deleteById(id);
	}

	@Override
	public List<String> getAllBookingUniqueSeats() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().map(Booking::getSeats)
				.distinct().collect(Collectors.toList());
	}

	@Override
	public Long getBookingCountTotal() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().count();
	}

	@Override
	public List<Booking> getBookingPaymentStatusCheck() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().filter(Booking-> Booking.getPaymentStatus()
				.startsWith("C")).toList();
	}

	@Override
	public List<Booking> getBookingPaymentMethodCheck() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().filter(Booking-> Booking.getPaymentMethod()
				.contains("Credit Card")).toList();
	}

	@Override
	public List<Booking> getBookingStatus() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().filter(Booking -> Booking.getBookingStatus()
				.contains("Pendding")).toList();
	}

	@Override
	public List<Booking> getBookingTotalCostAscendingOrder() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().sorted(Comparator.comparing(Booking::getTotalCost)).toList();
	}

	@Override
	public List<Booking> getBookingTotalCostGreaterThan60000() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().filter(Booking -> Booking.getTotalCost() 
				> 60000).toList();
	}

	@Override
	public Map<String, Long> getBookingCountBySeats() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream()
				.collect(Collectors.groupingBy(Booking -> Booking.getSeats().toUpperCase(),Collectors.counting()));
	}

	@Override
	public List<Booking> getBookingPaymentStatusCompleted() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().filter(Booking -> Booking.getPaymentStatus()
				.equalsIgnoreCase("Completed")).toList();
	}

	@Override
	public Map<String, Long> getBookingCountByPaymentStatus() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll().stream().collect(Collectors.groupingBy(Booking::getPaymentStatus,
				Collectors.counting()));
	}
	
}
