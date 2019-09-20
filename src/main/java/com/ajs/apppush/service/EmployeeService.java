package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.Employee;
import com.ajs.apppush.input.employee.SaveEmployee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	
	public Employee getEmployee(int idx);
	public Employee saveEmployee(SaveEmployee employeeInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
