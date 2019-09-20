package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.EmployeeLike;
import com.ajs.apppush.input.employeeLike.SaveEmployeeLike;

public interface EmployeeLikeService {

	public List<EmployeeLike> getAllEmployeeLike();
	
	public EmployeeLike getEmployeeLike(int idx);
	public EmployeeLike saveEmployeeLike(SaveEmployeeLike employeeLikeInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
