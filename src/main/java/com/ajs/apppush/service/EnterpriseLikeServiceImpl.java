package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.EnterpriseLike;
import com.ajs.apppush.input.enterpriseLike.SaveEnterpriseLike;
import com.ajs.apppush.repository.EnterpriseLikeRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EnterpriseLikeServiceImpl implements EnterpriseLikeService{

	@Autowired
	private EnterpriseLikeRepository enterpriseLikeRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllEnterpriseLike")
	public List<EnterpriseLike> getAllEnterpriseLike() {
		return enterpriseLikeRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getEnterpriseLike")
	public EnterpriseLike getEnterpriseLike(int idx) {

		Optional<EnterpriseLike> opLike = enterpriseLikeRepository.findById(idx);
		
		if(opLike.isPresent()) {
			return opLike.get();
		} else {
			return null;
		}
		
	}

	@Override
	@GraphQLMutation(name = "saveEnterpriseLike")
	public EnterpriseLike saveEnterpriseLike(SaveEnterpriseLike enterpriseLikeInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		EnterpriseLike enterpriseLike = enterpriseLikeRepository.findById(enterpriseLikeInput.getIdx())
				.orElseGet(() -> new EnterpriseLike());
		
		EnterpriseLike newEnterpriseLike = (EnterpriseLike) reflectionUtil.overWriteProperties(enterpriseLike, enterpriseLikeInput);
		
		return enterpriseLikeRepository.save(newEnterpriseLike);
		
	}

}
