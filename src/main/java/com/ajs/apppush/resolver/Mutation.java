package com.ajs.apppush.resolver;

import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.entity.UserInput;
import com.ajs.apppush.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver{

	private UserRepository userRepository;
	
	public Mutation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User saveUser(UserInput userInput) {
		
		User user = new User();
		
		user.setUserId(userInput.getUserId());
		user.setNickNm(userInput.getNickNm());
		
		return userRepository.save(user);
	}
}
