package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.PushNotification;
import com.ajs.apppush.input.pushNotification.SavePushNotification;
import com.ajs.apppush.repository.PushNotificationRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class PushNotificationServiceImpl implements PushNotificationService{

	@Autowired
	private PushNotificationRepository pushNotificationRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllPushNotification")
	public List<PushNotification> getAllPushNotification() {
		return pushNotificationRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getPushNotification")
	public PushNotification getPushNotification(int idx) {

		Optional<PushNotification> opPush = pushNotificationRepository.findById(idx);
		
		if(opPush.isPresent()) {
			return opPush.get();
		} else {
			return null;
		}
		
	}

	@Override
	@GraphQLMutation(name = "savePushNotification")
	public PushNotification savePushNotification(SavePushNotification pushNotificationInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		PushNotification push = pushNotificationRepository.findById(pushNotificationInput.getIdx())
				.orElseGet(() -> new PushNotification());
		
		PushNotification newPush = (PushNotification) reflectionUtil.overWriteProperties(push, pushNotificationInput);
		
		return pushNotificationRepository.save(newPush);
	}

}
