package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.EmployeeStar;
import com.ajs.apppush.input.employeeStar.SaveEmployeeStar;

public interface EmployeeStarService {

	public List<EmployeeStar> getAllEmployeeStar();
	
	public EmployeeStar getEmployeeStar(int idx);
	public EmployeeStar saveEmployeeStar(SaveEmployeeStar employeeStarInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
