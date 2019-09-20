package com.ajs.apppush.input.photo;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavePhoto {

	private int idx;
	private int employeeIdx;
	private String filePath;
}
