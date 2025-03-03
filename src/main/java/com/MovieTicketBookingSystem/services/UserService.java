package com.MovieTicketBookingSystem.services;

import java.util.List;
import java.util.Optional;

import com.MovieTicketBookingSystem.entities.User;

public interface UserService {

	public User createUser(User user);
	public Optional<User> getUserById(Long id);
	public List<User> getAllUsers(User user);
	public User updateUser(User user);
	public void deleteUserById(Long id);
}
