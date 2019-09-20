package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.Contents;
import com.ajs.apppush.input.contents.SaveContents;
import com.ajs.apppush.repository.ContentsRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class ContentsServiceImpl implements ContentsService{

	@Autowired
	private ContentsRepository contentsRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllContents")
	public List<Contents> getAllContents() {
		return contentsRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getContents")
	public Contents getContents(int idx) {
		Optional<Contents> opContents = contentsRepository.findById(idx);
		
		if(opContents.isPresent()) {
			return opContents.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "saveContents")
	public Contents saveContents(SaveContents contentsInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Contents contents = contentsRepository.findById(contentsInput.getIdx())
				.orElseGet(() -> new Contents());
		
		Contents newContents = (Contents) reflectionUtil.overWriteProperties(contents, contentsInput);
		
		return contentsRepository.save(newContents);
		
	}

}
