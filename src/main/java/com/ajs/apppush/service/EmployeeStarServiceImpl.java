package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.EmployeeStar;
import com.ajs.apppush.input.employeeStar.SaveEmployeeStar;
import com.ajs.apppush.repository.EmployeeStarRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EmployeeStarServiceImpl implements EmployeeStarService{

	@Autowired
	private EmployeeStarRepository employeeStarRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllEmployeeStar")
	public List<EmployeeStar> getAllEmployeeStar() {
		return employeeStarRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getEmployeeStar")
	public EmployeeStar getEmployeeStar(int idx) {

		Optional<EmployeeStar> opStar = employeeStarRepository.findById(idx);
		
		if(opStar.isPresent()) {
			return opStar.get();
		} else {
			return null;
		}
		
	}

	@Override
	@GraphQLMutation(name = "saveEmployeeStar")
	public EmployeeStar saveEmployeeStar(SaveEmployeeStar employeeStarInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		EmployeeStar employeeStar = employeeStarRepository.findById(employeeStarInput.getIdx())
				.orElseGet(() -> new EmployeeStar());
		
		EmployeeStar newEmployeeStar = (EmployeeStar) reflectionUtil.overWriteProperties(employeeStar, employeeStarInput);
		
		return employeeStarRepository.save(newEmployeeStar);
		
	}

}
