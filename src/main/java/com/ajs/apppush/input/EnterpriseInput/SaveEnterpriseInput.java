package com.ajs.apppush.input.EnterpriseInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEnterpriseInput {
	
	private int idx;
	private String name;
	private String thumbnail;
	private String intro;
}
