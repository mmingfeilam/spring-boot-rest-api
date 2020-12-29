package me.lam.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.lam.model.User;
import me.lam.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/user")
	public Collection<User> index() {
		return userService.findAllActiveUsers();
	}

	@PostMapping("/user/search_status_name")
	public User search(@RequestBody Map<String, String> body) {
		Integer status = Integer.parseInt(body.get("status"));
		String firstName = body.get("firstName");

		return userService.findUserByStatusAndNameNamedParams(status, firstName);
	}

}