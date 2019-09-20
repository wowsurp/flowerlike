package com.ajs.apppush.input.donation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveDonation {

	private int idx;
	private String fromId;
	private int price;
	private String status;
	private String toId;
	
}
