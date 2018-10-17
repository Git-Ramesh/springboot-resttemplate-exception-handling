package com.rs.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rs.app.exception.InvalidUserNameException;
import com.rs.app.exception.UserNotFoundException;
import com.rs.app.exception.handler.CustomResonseErrorHandler;
import com.rs.app.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
//	@Autowired
//	private CustomResonseErrorHandler errorHandler;

	List<User> users = null;

	public UserController() {
		users = Arrays.asList(new User("Ramesh", "rameshpanthangi08@gmail.com"), new User("Sowmya", "sowmya@test.com"));
	}

	public User getUser(String username) {
		if (username == null) {
			throw new InvalidUserNameException("username null not allowed");
		} else {
			Optional<User> optional = users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
			if (optional.isPresent()) {
				return optional.get();
			} else {
				throw new UserNotFoundException("User not available");
			}
		}
	}

	@GetMapping("/")
	public User userByRequestParam(@RequestParam("username") String username) {
		return getUser(username);
	}

	@GetMapping("/{username}")
	public User userByPathVariable(@PathVariable("username") String username) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new CustomResonseErrorHandler());
		return restTemplate.getForObject("http://localhost:8080/user/?username="+username, User.class);
	}
}
