package com.myapp.usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.usermanagement.entity.User;
import com.myapp.usermanagement.repository.UserRepository;
import com.myapp.usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId).get();
	}

}
