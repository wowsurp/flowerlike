package com.ajs.apppush.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.Employee;
import com.ajs.apppush.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class EmployeeQuery implements GraphQLQueryResolver{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeQuery(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Iterable<Employee> fetchAllEmployee(){
		return employeeRepository.findAll();
	}

}
