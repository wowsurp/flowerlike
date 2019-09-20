package com.ajs.apppush.input.enterpriseAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEnterpriseAddress {

	private int idx;
	private String address;
	private String addressType;
	private String buildingName;
	private int enterpriseIdx;
	private String jibunAddress;
	private String roadAddress;
	private String roadName;
	private String sido;
	private String sigungu;
	private String sigunguCode;
	private String zoneCode;
	
}
