package com.ajs.apppush.input.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrder {

	private int idx;
	private String device;
	private String iniKey;
	private int price;
	private String status;
	private String userId;
	
}
