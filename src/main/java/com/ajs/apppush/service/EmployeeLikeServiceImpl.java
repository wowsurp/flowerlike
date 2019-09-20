package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.EmployeeLike;
import com.ajs.apppush.input.employeeLike.SaveEmployeeLike;
import com.ajs.apppush.repository.EmployeeLikeRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EmployeeLikeServiceImpl implements EmployeeLikeService{

	@Autowired
	private EmployeeLikeRepository employeeLikeRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllEmployeeLike")
	public List<EmployeeLike> getAllEmployeeLike() {
		return employeeLikeRepository.findAll();
	}

	@Override
	@GraphQLQuery(name ="getEmployeeLike")
	public EmployeeLike getEmployeeLike(int idx) {

		Optional<EmployeeLike> opEmployeeLike = employeeLikeRepository.findById(idx);
		
		if(opEmployeeLike.isPresent()) {
			return opEmployeeLike.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "saveEmployeeLike")
	public EmployeeLike saveEmployeeLike(SaveEmployeeLike employeeLikeInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		EmployeeLike employeeLike = employeeLikeRepository.findById(employeeLikeInput.getIdx())
				.orElseGet(() -> new EmployeeLike());
		
		EmployeeLike newEmployeeLike = (EmployeeLike) reflectionUtil.overWriteProperties(employeeLike, employeeLikeInput);
		
		return employeeLikeRepository.save(newEmployeeLike);
		
	}

}
