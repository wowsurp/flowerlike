package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.Enterprise;
import com.ajs.apppush.input.Enterprise.SaveEnterprise;
import com.ajs.apppush.repository.EnterpriseRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{

	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getEnterprise")
	public Enterprise getEnterprise(int idx) {
		Optional<Enterprise> opEnterprise = enterpriseRepository.findById(idx);
		
		if(opEnterprise.isPresent()) {
			return opEnterprise.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "saveEnterprise")
	public Enterprise saveEnterprise(SaveEnterprise enterpriseInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Enterprise enterprise = enterpriseRepository.findById(enterpriseInput.getIdx())
				.orElseGet(() -> new Enterprise());
		
		Enterprise newEnterprise = (Enterprise) reflectionUtil.overWriteProperties(enterprise, enterpriseInput);
		
		return enterpriseRepository.save(newEnterprise);
	}

}
