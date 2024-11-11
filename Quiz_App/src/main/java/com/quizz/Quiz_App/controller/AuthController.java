package com.quizz.Quiz_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizz.Quiz_App.model.User;
import com.quizz.Quiz_App.repository.UserRepository;
 
@Controller
public class AuthController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@RequestParam String username, @RequestParam String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		userRepository.save(user);
		return "redirect:/login";
	}

}
