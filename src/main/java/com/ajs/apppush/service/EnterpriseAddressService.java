package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.EnterpriseAddress;
import com.ajs.apppush.input.enterpriseAddress.SaveEnterpriseAddress;

public interface EnterpriseAddressService {

	public List<EnterpriseAddress> getAllEnterpriseAddress();
	
	public EnterpriseAddress getEnterpriseAddress(int idx);
	public EnterpriseAddress saveEnterpriseAddress(SaveEnterpriseAddress enterpriseAddressInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
