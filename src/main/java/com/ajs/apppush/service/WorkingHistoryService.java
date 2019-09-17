package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;

import com.ajs.apppush.entity.WorkingHistory;
import com.ajs.apppush.input.WorkingHistory.SaveWorkingHistory;

public interface WorkingHistoryService {
	
	public WorkingHistory getWorkingHistory(int idx);
	public WorkingHistory saveWorkingHistory(SaveWorkingHistory workingHistoryInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

}
