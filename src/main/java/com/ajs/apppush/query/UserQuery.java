package com.ajs.apppush.query;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class UserQuery implements GraphQLQueryResolver{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserQuery(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Iterable<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public User getUser(String userId) {
		
		User user = null;
		
		Optional<User> opUser = userRepository.findById(userId);
		
		if(opUser.isPresent()) {
			user = opUser.get();
		}
		
		return user;
	}

}
