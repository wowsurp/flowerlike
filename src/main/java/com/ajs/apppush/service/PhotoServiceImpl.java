package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.Photo;
import com.ajs.apppush.input.photo.SavePhoto;
import com.ajs.apppush.repository.PhotoRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllPhoto")
	public List<Photo> getAllPhoto() {
		return photoRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getPhoto")
	public Photo getPhoto(int idx) {
		Optional<Photo> opPhoto = photoRepository.findById(idx);
		
		if(opPhoto.isPresent()) {
			return opPhoto.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "savePhoto")
	public Photo savePhoto(SavePhoto photoInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Photo photo = photoRepository.findById(photoInput.getIdx())
				.orElseGet(() -> new Photo());
		
		Photo newPhoto = (Photo) reflectionUtil.overWriteProperties(photo, photoInput);
		
		return photoRepository.save(newPhoto); 
		
	}

}
