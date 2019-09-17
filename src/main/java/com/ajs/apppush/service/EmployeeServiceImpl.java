package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.Employee;
import com.ajs.apppush.input.Employee.SaveEmployee;
import com.ajs.apppush.repository.EmployeeRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRespository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getEmployee")
	public Employee getEmployee(int idx) {
		Optional<Employee> opEmployee = employeeRespository.findById(idx);
		
		if(opEmployee.isPresent()) {
			return opEmployee.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "saveEmployee")
	public Employee saveEmployee(SaveEmployee employeeInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Employee employee = employeeRespository.findById(employeeInput.getIdx())
				.orElseGet(() -> new Employee());
		
		Employee newEmployee = (Employee)reflectionUtil.overWriteProperties(employee, employeeInput);
		
		return employeeRespository.save(newEmployee);
	}

}
