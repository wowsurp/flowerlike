package com.ajs.apppush.input.EmployeeInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployeeInput {

	private int idx;
	private int enterpriseIdx;
	private String userId;
	private String nickNm;
	private String introduction;
	private String workingHours;
	private String delYn;
	private String requestAgreeYn;
	
}
