//package com.ajs.apppush.mutation;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ajs.apppush.entity.Enterprise;
//import com.ajs.apppush.entity.WorkingHistory;
//import com.ajs.apppush.input.WorkingHistoryInput.SaveWorkingHistoryInput;
//import com.ajs.apppush.repository.EnterpriseRepository;
//import com.ajs.apppush.repository.WorkingHistoryRepository;
//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//
//@Component
//public class WorkingHistoryMutation implements GraphQLMutationResolver{
//	
//	@Autowired
//	private WorkingHistoryRepository workingHistoryRepository;
//	
//	@Autowired
//	private EnterpriseRepository enterpriseRepository;
//	
//	public WorkingHistoryMutation(WorkingHistoryRepository workingHistoryRepository) {
//		this.workingHistoryRepository = workingHistoryRepository;
//	}
//	
//	public WorkingHistory saveWorkingHistory(SaveWorkingHistoryInput workingHistoryInput) {
//		
//		WorkingHistory workingHistory = null;
//		
//		Optional<WorkingHistory> opWorkingHistory = workingHistoryRepository.findById(workingHistoryInput.getIdx());
//		Optional<Enterprise> opEnterprise = enterpriseRepository.findById(workingHistoryInput.getEnterpriseIdx());
//		
//		Enterprise enterprise = opEnterprise.get();
//		
//		String enterpriseName = enterprise.getName();
//		
//		if(opWorkingHistory.isPresent()) {
//			
//			workingHistory = opWorkingHistory.get();
//			
//			workingHistory.setEnterpriseIdx(workingHistoryInput.getEnterpriseIdx());
//			workingHistory.setStartDtm(workingHistoryInput.getStartDtm());
//			workingHistory.setEndDtm(workingHistoryInput.getEndDtm());
//			workingHistory.setEmployeeId(workingHistoryInput.getEmployeeId());
//			
//			workingHistory.setEnterpriseName(enterpriseName);
//			
//		} else {
//			
//			workingHistory = new WorkingHistory();
//			
//			workingHistory.setEnterpriseIdx(workingHistoryInput.getEnterpriseIdx());
//			workingHistory.setStartDtm(workingHistoryInput.getStartDtm());
//			workingHistory.setEndDtm(workingHistoryInput.getEndDtm());
//			workingHistory.setEmployeeId(workingHistoryInput.getEmployeeId());
//			
//			workingHistory.setEnterpriseName(enterpriseName);
//			
//		}
//		
//		return workingHistoryRepository.save(workingHistory);
//		
//	}
//}
