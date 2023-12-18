package com.gowtham.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gowtham.model.User;
import com.gowtham.repositories.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = (User) userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username or Passowrd Not Found");
		}
		return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities());
	}
	
	public Collection<? extends GrantedAuthority> authorities() {
	    return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

}
