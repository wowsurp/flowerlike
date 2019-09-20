package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.PushNotification;
import com.ajs.apppush.input.pushNotification.SavePushNotification;

public interface PushNotificationService {

	public List<PushNotification> getAllPushNotification();
	
	public PushNotification getPushNotification(int idx);
	public PushNotification savePushNotification(SavePushNotification pushNotificationInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
