package com.MovieTicketBookingSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieTicketBookingSystem.entities.ShowMovie;

@Repository
public interface ShowMovieDao extends JpaRepository<ShowMovie, Long>{

}
