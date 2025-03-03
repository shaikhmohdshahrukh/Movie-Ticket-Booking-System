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
import com.MovieTicketBookingSystem.dtos.BookingDto;
import com.MovieTicketBookingSystem.entities.Booking;
import com.MovieTicketBookingSystem.entities.ShowMovie;
import com.MovieTicketBookingSystem.services.BookingService;
import com.MovieTicketBookingSystem.services.ShowMovieService;

@RestController
public class BookingController {

	@Autowired
	public BookingService bookingService;
	
	@Autowired
	public ShowMovieService showMovieService;
	
	@GetMapping("/bookings")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}

	@GetMapping("/bookings/{bookingId}")
	public ResponseEntity<?> getByBookingId(@PathVariable Long bookingId) {
		Optional<Booking> optionalBooking = bookingService.getBookingById(bookingId);
		if (optionalBooking.isPresent())
			return new ResponseEntity<Booking>(optionalBooking.get(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Booking Not Found", HttpStatus.NOT_FOUND);
	}
	
//	@PostMapping("/bookings")
//	public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
//		bookingService.createBooking(booking);
//		return new ResponseEntity<String>("Booking Created Successfully ", HttpStatus.CREATED);
//	}
	
	@PostMapping("/bookings")
	public ResponseEntity<?> createBooking(@RequestBody BookingDto bookingDto){
		Booking booking = bookingDto.getBooking();
		Optional<ShowMovie> showMovie = showMovieService.getShowMovieById(bookingDto.getShowMovieId());
		booking.setShowMovie(showMovie.get());
		bookingService.createBooking(booking);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<?> deleteByBookingId(@PathVariable Long bookingId) {
		bookingService.deleteByBookingId(bookingId);
		return new ResponseEntity<String>("Movie Deleted Successfully", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/bookings/{bookingId}")
	public ResponseEntity<?> updateBooking(@RequestBody Booking booking) {
		booking = bookingService.updateBooking(booking);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	} 	
	
	@GetMapping("/bookings/unique-seats")
	public ResponseEntity<?> getAllBookingUniqueSeats(){
		return ResponseEntity.ok(bookingService.getAllBookingUniqueSeats());
	}
	
	@GetMapping("/bookings/count-total")
	public ResponseEntity<?> getBookingCountTotal(){
		return ResponseEntity.ok(bookingService.getBookingCountTotal());
	}
	
	@GetMapping("/bookings/check-payment-status")
	public ResponseEntity<?> getBookingPaymentStatusCheck(){
		return ResponseEntity.ok(bookingService.getBookingPaymentStatusCheck());
	}
	
	@GetMapping("/bookings/check-payment-method")
	public ResponseEntity<?> getBookingPaymentMethodCheck(){
		return ResponseEntity.ok(bookingService.getBookingPaymentMethodCheck());
	}
	
	@GetMapping("/bookings/check-booking-status")
	public ResponseEntity<?> getBookingStatus(){
		return ResponseEntity.ok(bookingService.getBookingStatus());
	}
	
	@GetMapping("/bookings/total-cost-ascending-order")
	public ResponseEntity<?> getBookingTotalCostAscendingOrder(){
		return ResponseEntity.ok(bookingService.getBookingTotalCostAscendingOrder());
	}
	
	@GetMapping("/bookings/total-cost-greater-than-60000")
	public ResponseEntity<?> getBookingTotalCostGreaterThan60000(){
		return ResponseEntity.ok(bookingService.getBookingTotalCostGreaterThan60000());
	}
	
	@GetMapping("/bookings/count-total-seats")
	public ResponseEntity<?> getBookingCountBySeats(){
		return ResponseEntity.ok(bookingService.getBookingCountBySeats());
	}
	
	@GetMapping("/bookings/check-payment-status-confirmed")
	public ResponseEntity<?> getBookingPaymentStatusConfirmed(){
		return ResponseEntity.ok(bookingService.getBookingPaymentStatusCompleted());
	}
	
	@GetMapping("/bookings/payment-status-count-by-completed")
	public ResponseEntity<?> getBookingCountByPaymentStatus(){
		return ResponseEntity.ok(bookingService.getBookingCountByPaymentStatus());
	}
}
