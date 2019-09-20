package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.Photo;
import com.ajs.apppush.input.photo.SavePhoto;

public interface PhotoService {

	public List<Photo> getAllPhoto();
	
	public Photo getPhoto(int idx);
	public Photo savePhoto(SavePhoto photoInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
