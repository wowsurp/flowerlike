package com.ajs.apppush.input.WorkingHistoryInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveWorkingHistoryInput {

	private int idx;
	private int enterpriseIdx;
	private String startDtm;
	private String endDtm;
	private String employeeId;
	
}
