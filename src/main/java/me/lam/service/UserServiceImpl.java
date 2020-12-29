package me.lam.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.lam.model.User;
import me.lam.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRespository;

	public List<User> findAll() {
		return userRespository.findAll();
	}

	public Collection<User> findAllActiveUsers() {
		return userRespository.findAllActiveUsers();
	}

	// public List<User> findAllUsers(Sort sort) {
	// return userRespository.findAllUsers(sort);
	// }

	public User findUserByStatusAndNameNamedParams(Integer status, String name) {
		return userRespository.findUserByStatusAndNameNamedParams(status, name);
	}

}
