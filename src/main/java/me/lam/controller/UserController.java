package me.lam.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.lam.model.User;
import me.lam.model.UserType;
import me.lam.repository.UserTypeRepository;
import me.lam.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserTypeRepository userTypeRespository;

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

	@PostMapping("/user")
	public User create(@RequestBody Map<String, String> body) {
		Integer userTypeId = Integer.parseInt(body.get("userTypeId"));
		String firstName = body.get("firstName");
		String lastName = body.get("lastName");
		String password = body.get("password");
		String email = body.get("email");
		String sex = body.get("sex");
		Boolean active = Boolean.parseBoolean(body.get("active"));
		Integer status = Integer.parseInt(body.get("status"));

		UserType userType = userTypeRespository.findOne(userTypeId);
		return userService.save(new User(userType, firstName, lastName, password, email, sex, active, status));
	}

}