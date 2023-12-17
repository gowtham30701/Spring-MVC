package com.gowtham.service;

import com.gowtham.dto.UserDto;
import com.gowtham.model.User;

public interface UserService {

	
	User findByUsername(String username);
	User save(UserDto userDto);
	
}
