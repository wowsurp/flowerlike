package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;

import com.ajs.apppush.entity.Employee;
import com.ajs.apppush.input.Employee.SaveEmployee;

public interface EmployeeService {

	public Employee getEmployee(int idx);
	public Employee saveEmployee(SaveEmployee employeeInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
