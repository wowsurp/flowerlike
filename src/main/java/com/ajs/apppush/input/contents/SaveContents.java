package com.ajs.apppush.input.contents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveContents {

	private int idx;
	private String contents;
	private int enterpriseIdx;
	private int priority;
	private String title;
	private String userId;
	
}
