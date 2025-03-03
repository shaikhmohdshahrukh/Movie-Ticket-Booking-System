package com.MovieTicketBookingSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MovieTicketBookingSystem.entities.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long>{

}
