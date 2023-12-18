package com.gowtham.service;

import org.springframework.stereotype.Service;

import com.gowtham.dto.UserDto;
import com.gowtham.model.User;


public interface UserService {

	
	User findByUsername(String username);
	User save(UserDto userDto);
	
}
