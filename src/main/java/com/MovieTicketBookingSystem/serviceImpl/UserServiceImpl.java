package com.MovieTicketBookingSystem.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MovieTicketBookingSystem.daos.UserDao;
import com.MovieTicketBookingSystem.entities.User;
import com.MovieTicketBookingSystem.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userRepo;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public List<User> getAllUsers(User user) {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}
}
