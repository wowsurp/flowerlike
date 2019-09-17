package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;

import com.ajs.apppush.entity.Enterprise;
import com.ajs.apppush.input.Enterprise.SaveEnterprise;

public interface EnterpriseService {

	public Enterprise getEnterprise(int idx);
	public Enterprise saveEnterprise(SaveEnterprise enterpriseInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
