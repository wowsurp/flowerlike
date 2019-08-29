package com.ajs.apppush.input.UserInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveUserInput {

	private String userId;
	private String nickNm;
	private String email;
	private String token;
	private String profile;
	private String grade;
	private String type;
	private long point;
	private String status;
	private String regDtm;
	private String device;
	private String intro;
}