package me.lam.service;

import java.util.Collection;
import java.util.List;

import me.lam.model.User;

public interface UserService {
	List<User> findAll();

	Collection<User> findAllActiveUsers();

	// List<User> findAllUsers(Sort sort);

	User findUserByStatusAndNameNamedParams(Integer status, String name);

	User save(User user);

	// void delete(int id);

	User findOne(String username);

	User findById(Long id);

	// User update(User user);

}
