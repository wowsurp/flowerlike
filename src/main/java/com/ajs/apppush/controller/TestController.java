package com.ajs.apppush.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajs.apppush.entity.Donation;
import com.ajs.apppush.entity.Photo;
import com.ajs.apppush.util.HttpSender;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		
		HttpSender httpSender = new HttpSender();
		
		Map<String, String> params = new HashMap<>();

		String url = "https://exp.host/--/api/v2/push/send";
		
		params.put("to", "ExponentPushToken[bMrhhHFbkC6Bh5LvD4CYme]");
		params.put("title", "hello");
		params.put("body", "world");
		
		return httpSender.sendAppPush(url, params);
	}

}
