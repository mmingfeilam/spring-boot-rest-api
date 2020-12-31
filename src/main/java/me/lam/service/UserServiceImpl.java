package me.lam.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.lam.model.User;
import me.lam.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	@Autowired
	UserRepository userRespository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

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

	@Transactional
	public User save(User user) {
		return userRespository.save(user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRespository.findUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	// @Override
	// public void delete(int id) {
	// userDao.deleteById(id);
	// }

	@Override
	public User findOne(String username) {
		return userRespository.findUserByUserName(username);
		// return null;
	}

	@Override
	public User findById(Long id) {
		// Optional<User> optionalUser = userRespository.findUserById(id);
		// return optionalUser.isPresent() ? optionalUser.get() : null;
		return userRespository.findUserById(id);
	}

	// @Override
	// public User update(User user) {
	// User user = findById(userDto.getId());
	// if(user != null) {
	//// BeanUtils.copyProperties(userDto, user, "password");
	// return userRespository.save(user);
	// }
	// return userDto;
	// }

}
