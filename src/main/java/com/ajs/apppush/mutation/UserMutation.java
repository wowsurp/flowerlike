package com.ajs.apppush.mutation;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.input.UserInput.SaveUserInput;
import com.ajs.apppush.repository.UserRepository;
import com.ajs.apppush.util.ReflectionUtil;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class UserMutation implements GraphQLMutationResolver{

	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	public UserMutation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User saveUser(SaveUserInput userInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		User user = userRepository.findById(userInput.getUserId())
				.orElseGet(() -> new User());
		
		User newUser = (User)reflectionUtil.overWriteProperties(user, userInput);

		return userRepository.save(newUser);
	}	
}
