package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.exception.InvalidCredentialsException;
import com.ajs.apppush.input.User.SaveUser;
import com.ajs.apppush.repository.UserRepository;
import com.ajs.apppush.security.jwt.JwtTokenUtil;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class UserServiceImpl implements UserService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	@GraphQLQuery(name = "getUser")
	public User getUser(String userId) {
		
		Optional<User> opUser = userRepository.findById(userId);
		
		if(opUser.isPresent()) {
			return opUser.get();
		} else {
			return null;
		}
	}
	
	@Override
	@GraphQLMutation(name = "saveUser")
	public User saveUser(SaveUser userInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		User user = userRepository.findById(userInput.getUserId())
				.orElseGet(() -> new User());
		
		User newUser = (User)reflectionUtil.overWriteProperties(user, userInput);

		return userRepository.save(newUser);
	}

	@Override
	@GraphQLMutation(name = "signin")
	public String signin(String userId, String email) throws InvalidCredentialsException {
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			if(email.equals(user.get().getEmail())) {
				logger.info("success...");
				return jwtTokenUtil.generateToken(user.get().getUserId(), user.get().getEmail());
			} else {
				logger.info("Invalid email");
                throw new InvalidCredentialsException("Invalid Credentials!");
			}
		} else {
			logger.info("Invalid user");
            throw new InvalidCredentialsException("Invalid Credentials!");
		}
	}

}
