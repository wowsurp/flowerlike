package com.ajs.apppush.resolver;

import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{
	
	private UserRepository userRepository;
	
	public Query(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Iterable<User> fetchAllUser(){
		return userRepository.findAll();
	}

}
