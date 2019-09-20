package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.EnterpriseStar;
import com.ajs.apppush.input.enterpriseStar.SaveEnterpriseStar;
import com.ajs.apppush.repository.EnterpriseStarRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EnterpriseStarServiceImpl implements EnterpriseStarService{

	@Autowired
	private EnterpriseStarRepository enterpriseStarRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllEnterpriseStar")
	public List<EnterpriseStar> getAllEnterpriseStar() {
		return enterpriseStarRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getEnterpriseStar")
	public EnterpriseStar getEnterpriseStar(int idx) {
		
		Optional<EnterpriseStar> opStar = enterpriseStarRepository.findById(idx);
		
		if(opStar.isPresent()) {
			return opStar.get();
		} else {
			return null;
		}
		
	}

	@Override
	@GraphQLMutation(name = "saveEnterpriseStar")
	public EnterpriseStar saveEnterpriseStar(SaveEnterpriseStar enterpriseStarInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		EnterpriseStar enterpriseStar = enterpriseStarRepository.findById(enterpriseStarInput.getIdx())
				.orElseGet(() -> new EnterpriseStar());
		
		EnterpriseStar newEnterpriseStar = (EnterpriseStar) reflectionUtil.overWriteProperties(enterpriseStar, enterpriseStarInput);
		
		return enterpriseStarRepository.save(newEnterpriseStar);
		
	}

}
