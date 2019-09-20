package com.ajs.apppush.input.pushNotification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavePushNotification {

	private int idx;
	private String link;
	private String title;
	private String message;
	private String reciever;
	private String sender;
	private String sendDt;
	private String sendHour;
	private String sendMinute;
	
}
