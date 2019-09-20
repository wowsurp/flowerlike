package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.WorkingHistory;
import com.ajs.apppush.input.workingHistory.SaveWorkingHistory;

public interface WorkingHistoryService {
	
	public List<WorkingHistory> getAllWorkingHistory();
	
	public WorkingHistory getWorkingHistory(int idx);
	public WorkingHistory saveWorkingHistory(SaveWorkingHistory workingHistoryInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

}
