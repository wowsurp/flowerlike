//package com.ajs.apppush.query;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ajs.apppush.entity.WorkingHistory;
//import com.ajs.apppush.repository.WorkingHistoryRepository;
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//
//@Component
//public class WorkingHistoryQuery implements GraphQLQueryResolver{
//
//	@Autowired
//	private WorkingHistoryRepository workingHistoryRepository;
//	
//	public WorkingHistoryQuery(WorkingHistoryRepository workingHistoryRepository) {
//		this.workingHistoryRepository = workingHistoryRepository;
//	}
//	
//	public Iterable<WorkingHistory> getAllWorkingHistory(){
//		return workingHistoryRepository.findAll();
//	}
//	
//	public WorkingHistory getWorkingHistory(int idx) {
//		
//		WorkingHistory workingHistory = null;
//		
//		Optional<WorkingHistory> opWorkingHistory = workingHistoryRepository.findById(idx);
//		
//		if(opWorkingHistory.isPresent()) {
//			workingHistory = opWorkingHistory.get();
//		}
//		
//		return workingHistory;
//	}
//}
