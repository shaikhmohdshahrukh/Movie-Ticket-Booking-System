package com.MovieTicketBookingSystem.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MovieTicketBookingSystem.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
