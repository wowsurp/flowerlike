package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.Contents;
import com.ajs.apppush.input.contents.SaveContents;

public interface ContentsService {

	public List<Contents> getAllContents();
	
	public Contents getContents(int idx);
	public Contents saveContents(SaveContents contentsInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
