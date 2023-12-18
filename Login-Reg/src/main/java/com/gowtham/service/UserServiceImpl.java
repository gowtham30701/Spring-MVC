package com.gowtham.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gowtham.dto.UserDto;
import com.gowtham.model.User;
import com.gowtham.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	private PasswordEncoder passwordEncoder ;
	
	private final UserRepository userRepository;
	
	@Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

	@Override
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		
		User user = new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()));
		return userRepository.save(user);
	}

	
}
