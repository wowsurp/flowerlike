package com.ajs.apppush.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpSender {

	public String sendAppPush(String url, Object params) {

		HttpHeaders httpHeaders = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		
		String body = null;
		
		try {
			body = objectMapper.writeValueAsString(params);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<?> httpEntity = new HttpEntity<>(body, httpHeaders);
		return restTemplate.postForEntity(url, httpEntity, String.class).getBody();
		
	}

}
