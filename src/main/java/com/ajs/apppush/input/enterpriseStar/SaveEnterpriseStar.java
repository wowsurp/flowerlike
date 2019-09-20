package com.ajs.apppush.input.enterpriseStar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEnterpriseStar {

	private int idx;
	private int enterpriseIdx;
	private int star;
	private String userId;
	
}
