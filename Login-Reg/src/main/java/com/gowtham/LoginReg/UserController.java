package com.gowtham.LoginReg;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gowtham.dto.UserDto;
import com.gowtham.service.UserService;

@Controller
public class UserController {
	
	 
	  @Autowired
	  private  UserDetailsService userDetailsService;
	  
	  private  UserService userService;
	  
	  public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/home")
	public String home(Model model, Principal principal) {
	    UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
	    model.addAttribute("userdetails", userDetails);
	    return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model , UserDto userDto) {
		model.addAttribute("user" ,userDto);
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model , UserDto userDto) {
        model.addAttribute("user", userDto); 
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSave(@ModelAttribute("user") UserDto userDto) {
		userService.save(userDto);
		return "register";
	}
}
