package com.ajs.apppush.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AndroidPushNotificationsService {

	private static final String firebase_server_key="AAAASoo6Ws0:APA91bE42zBPGK0jXWSKncgzlPXRjMkW8FUDEnO4LyMXsJ9-86ZmZ00FZPWGf14vBSt3KvVZqLoZ2hjKzIKt4lq0OSU95bmrf6YJ10TlWLru_4Eu_exQ1KSCH4xN5ZdItdzNmrd9mEz7";
    private static final String firebase_api_url="https://fcm.googleapis.com/fcm/send";

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new HeaderRequestInterceptor("Authorization",  "key=" + firebase_server_key));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; UTF-8 "));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }
}
