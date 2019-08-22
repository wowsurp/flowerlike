package com.ajs.apppush.mutation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.entity.UserInput;
import com.ajs.apppush.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class UserMutation implements GraphQLMutationResolver{

	private UserRepository userRepository;
	
	public UserMutation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User saveUser(UserInput userInput) {
		
		Optional<User> user = userRepository.findById(userInput.getUserId());
		
		user.get().setUserId(userInput.getUserId());
		user.get().setNickNm(userInput.getNickNm());
		
		return userRepository.save(user.get());
	}
}
