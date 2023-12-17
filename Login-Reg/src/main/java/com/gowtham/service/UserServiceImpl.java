package com.gowtham.service;

import org.springframework.stereotype.Service;

import com.gowtham.dto.UserDto;
import com.gowtham.model.User;
import com.gowtham.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		
		User user = new User(userDto.getUsername(), userDto.getPassword());
		return userRepository.save(user);
	}

	
}
