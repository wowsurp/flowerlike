package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.Enterprise;
import com.ajs.apppush.entity.WorkingHistory;
import com.ajs.apppush.input.workingHistory.SaveWorkingHistory;
import com.ajs.apppush.repository.EnterpriseRepository;
import com.ajs.apppush.repository.WorkingHistoryRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class WorkingHistoryServiceImpl implements WorkingHistoryService{

	@Autowired
	private WorkingHistoryRepository workingHistoryRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name= "getAllWorkingHistory")
	public List<WorkingHistory> getAllWorkingHistory() {
		return workingHistoryRepository.findAll();
	}
	
	@Override
	@GraphQLQuery(name = "getWorkingHistory")
	public WorkingHistory getWorkingHistory(int idx) {
		Optional<WorkingHistory> opWorkingGHistory = workingHistoryRepository.findById(idx);
		
		if(opWorkingGHistory.isPresent()) {
			return opWorkingGHistory.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "saveWorkingHistory")
	public WorkingHistory saveWorkingHistory(SaveWorkingHistory workingHistoryInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		WorkingHistory workingHistory = workingHistoryRepository.findById(workingHistoryInput.getIdx())
				.orElseGet(() -> new WorkingHistory());
		
		Enterprise enterprise = enterpriseRepository.findById(workingHistoryInput.getEnterpriseIdx()).get();
		
		WorkingHistory newWorkingHistory = (WorkingHistory) reflectionUtil.overWriteProperties(workingHistory, workingHistoryInput);
		
		newWorkingHistory.setEnterpriseName(enterprise.getName());
		
		return workingHistoryRepository.save(newWorkingHistory);
		
	}

}
