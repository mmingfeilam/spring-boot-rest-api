package me.lam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.lam.configuration.JwtTokenUtil;
import me.lam.model.ApiResponse;
import me.lam.model.AuthToken;
import me.lam.model.LoginUser;
import me.lam.model.User;
import me.lam.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		// try {
		// authenticationManager.authenticate(new
		// UsernamePasswordAuthenticationToken(loginUser.getUsername(),
		// loginUser.getPassword()));
		//
		// } catch(Exception ex) {
		// System.out.println(ex.getMessage());
		// }

		if (!authenticate(loginUser.getUsername(), loginUser.getPassword())) {
			throw new BadCredentialsException("Bad Credentials Lam");
		}

		final User user = userService.findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return new ApiResponse<>(200, "success", new AuthToken(token, user.getUserName()));
	}

	private boolean authenticate(String userName, String password) {
		User user = userService.findOne(userName);

		return user.getPassword().equals(password);
	}

}
