package com.ajs.apppush.query;

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
	
	public Iterable<User> fetchAllUser(){
		return userRepository.findAll();
	}

}
