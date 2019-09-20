package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.EnterpriseStar;
import com.ajs.apppush.input.enterpriseStar.SaveEnterpriseStar;

public interface EnterpriseStarService {

	public List<EnterpriseStar> getAllEnterpriseStar();
	
	public EnterpriseStar getEnterpriseStar(int idx);
	public EnterpriseStar saveEnterpriseStar(SaveEnterpriseStar enterpriseStarInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
