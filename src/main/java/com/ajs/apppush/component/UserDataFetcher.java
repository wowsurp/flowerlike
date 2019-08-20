package com.ajs.apppush.component;

import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.repository.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserDataFetcher implements DataFetcher<User>{

	private final UserRepository userRepository;
	
	public UserDataFetcher(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User get(DataFetchingEnvironment environment) throws Exception {
		String userId = environment.getArgument("userId");
		return userRepository.findByUserId(userId);
	}

}
