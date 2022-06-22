package com.myapp.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.usermanagement.entity.User;

@Service
public interface UserService {
	User addUser(User user);

	List<User> getAllUser();
	
	User getUserById(int userId);

	User updateUser(User user);

	void deleteUser(int userId);
}
