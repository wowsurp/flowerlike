package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;

import com.ajs.apppush.entity.User;
import com.ajs.apppush.exception.InvalidCredentialsException;
import com.ajs.apppush.input.User.SaveUser;

public interface UserService {

	public User getUser(String userId);
	public User saveUser(SaveUser userInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	public String signin(String userId, String email) throws InvalidCredentialsException;
	
}
