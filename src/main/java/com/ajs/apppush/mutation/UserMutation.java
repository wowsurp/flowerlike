package com.ajs.apppush.mutation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.input.UserInput.GetUserInput;
import com.ajs.apppush.input.UserInput.SaveUserInput;
import com.ajs.apppush.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class UserMutation implements GraphQLMutationResolver{

	private UserRepository userRepository;
	
	public UserMutation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User saveUser(SaveUserInput userInput) {
		
		User user = null;
		
		Optional<User> opUser = userRepository.findById(userInput.getUserId());
		
		if(opUser.isPresent()) {
			
			user = opUser.get();
			
			user.setNickNm(userInput.getNickNm());
			user.setEmail(userInput.getEmail());
			user.setToken(userInput.getToken());
			user.setProfile(userInput.getProfile());
			user.setDevice(userInput.getDevice());
			user.setIntro(userInput.getIntro());
			
		} else {
			
			user = new User();
			
			user.setUserId(userInput.getUserId());
			user.setNickNm(userInput.getNickNm());
			user.setEmail(userInput.getEmail());
			user.setToken(userInput.getToken());
			user.setProfile(userInput.getProfile());
			user.setGrade(userInput.getGrade());
			user.setType(userInput.getType());
			user.setDevice(userInput.getDevice());
			user.setIntro(userInput.getIntro());
			
		}
		
		return userRepository.save(user);
	}
	
	public User getUser(GetUserInput userInput) {
		
		User user = null;
		
		Optional<User> opUser = userRepository.findById(userInput.getUserId());
		
		if(opUser.isPresent()) {
			user = opUser.get();
		}
		
		return user;
	}
}
