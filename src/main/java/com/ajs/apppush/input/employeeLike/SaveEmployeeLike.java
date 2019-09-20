package com.ajs.apppush.input.employeeLike;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployeeLike {

	private int idx;
	private String employeeUserId;
	private String userId;
}
