package com.ajs.apppush.input.employeeStar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployeeStar {

	private int idx;
	private String employeeUserId;
	private int star;
	private String userId;
	
}
