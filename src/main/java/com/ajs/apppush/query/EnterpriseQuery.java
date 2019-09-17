//package com.ajs.apppush.query;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ajs.apppush.entity.Enterprise;
//import com.ajs.apppush.repository.EnterpriseRepository;
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//
//@Component
//public class EnterpriseQuery implements GraphQLQueryResolver{
//	
//	@Autowired
//	private EnterpriseRepository enterpriseRepository;
//	
//	public EnterpriseQuery(EnterpriseRepository enterpriseRepository) {
//		this.enterpriseRepository = enterpriseRepository;
//	}
//	
//	public Iterable<Enterprise> getAllEnterprise(){
//		return enterpriseRepository.findAll();
//	}
//	
//	public Enterprise getEnterprise(int idx) {
//		
//		Enterprise enterprise = null;
//		
//		Optional<Enterprise> opEnterprise = enterpriseRepository.findById(idx);
//		
//		if(opEnterprise.isPresent()) {
//			enterprise = opEnterprise.get();
//		}
//		
//		return enterprise;
//	}
//	
//}
