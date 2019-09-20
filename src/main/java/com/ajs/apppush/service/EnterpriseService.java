package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.Enterprise;
import com.ajs.apppush.input.enterprise.SaveEnterprise;

public interface EnterpriseService {

	public List<Enterprise> getAllEnterprise();
	
	public Enterprise getEnterprise(int idx);
	public Enterprise saveEnterprise(SaveEnterprise enterpriseInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
