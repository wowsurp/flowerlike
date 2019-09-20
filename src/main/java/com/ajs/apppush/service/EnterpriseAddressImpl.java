package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.EnterpriseAddress;
import com.ajs.apppush.input.enterpriseAddress.SaveEnterpriseAddress;
import com.ajs.apppush.repository.EnterpriseAddressRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EnterpriseAddressImpl implements EnterpriseAddressService{

	@Autowired
	private EnterpriseAddressRepository enterpriseAddressRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllEnterpriseAddress")
	public List<EnterpriseAddress> getAllEnterpriseAddress() {
		return enterpriseAddressRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getEnterpriseAddress")
	public EnterpriseAddress getEnterpriseAddress(int idx) {

		Optional<EnterpriseAddress> opAddress = enterpriseAddressRepository.findById(idx);
		
		if(opAddress.isPresent()) {
			return opAddress.get();
		} else {
			return null;
		}
		
	}

	@Override
	@GraphQLMutation(name = "saveEnterpriseAddress")
	public EnterpriseAddress saveEnterpriseAddress(SaveEnterpriseAddress enterpriseAddressInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		EnterpriseAddress address = enterpriseAddressRepository.findById(enterpriseAddressInput.getIdx())
				.orElseGet(() -> new EnterpriseAddress());
		
		EnterpriseAddress newAddress = (EnterpriseAddress)reflectionUtil.overWriteProperties(address, enterpriseAddressInput);
		
		return enterpriseAddressRepository.save(newAddress);
		
	}

}
