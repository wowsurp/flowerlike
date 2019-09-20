package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.Order;
import com.ajs.apppush.input.order.SaveOrder;

public interface OrderService {

	public List<Order> getAllOrder();
	
	public Order getOrder(int idx);
	public Order saveOrder(SaveOrder orderInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
