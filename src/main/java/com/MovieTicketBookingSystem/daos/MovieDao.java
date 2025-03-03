package com.MovieTicketBookingSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieTicketBookingSystem.entities.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Long>{

}
