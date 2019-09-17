//package com.ajs.apppush.mutation;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ajs.apppush.entity.Enterprise;
//import com.ajs.apppush.input.EnterpriseInput.SaveEnterpriseInput;
//import com.ajs.apppush.repository.EnterpriseRepository;
//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//
//@Component
//public class EnterpriseMutation implements GraphQLMutationResolver{
//
//	@Autowired
//	private EnterpriseRepository enterpriseRepository;
//	
//	public EnterpriseMutation(EnterpriseRepository enterpriseRepository) {
//		this.enterpriseRepository = enterpriseRepository;
//	}
//	
//	public Enterprise saveEnterprise(SaveEnterpriseInput enterpriseInput) {
//		
//		Enterprise enterprise = null;
//		
//		Optional<Enterprise> opEnterprise = enterpriseRepository.findById(enterpriseInput.getIdx());
//		
//		if(opEnterprise.isPresent()) {
//			
//			enterprise = opEnterprise.get();
//			
//			enterprise.setName(enterpriseInput.getName());
//			enterprise.setThumbnail(enterpriseInput.getThumbnail());
//			enterprise.setIntro(enterpriseInput.getIntro());
//			
//		} else {
//			
//			enterprise = new Enterprise();
//			
//			enterprise.setName(enterpriseInput.getName());
//			enterprise.setThumbnail(enterpriseInput.getThumbnail());
//			enterprise.setIntro(enterpriseInput.getIntro());
//		}
//		
//		return enterpriseRepository.save(enterprise);
//	}
//	
//}
