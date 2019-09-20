package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajs.apppush.entity.Order;
import com.ajs.apppush.input.order.SaveOrder;
import com.ajs.apppush.repository.OrderRepository;
import com.ajs.apppush.util.ReflectionUtil;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ReflectionUtil reflectionUtil;
	
	@Override
	@GraphQLQuery(name = "getAllOrder")
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "getOrder")
	public Order getOrder(int idx) {
		Optional<Order> opOrder = orderRepository.findById(idx);
		
		if(opOrder.isPresent()) {
			return opOrder.get();
		} else {
			return null;
		}
	}

	@Override
	@GraphQLMutation(name = "saveOrder")
	public Order saveOrder(SaveOrder orderInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Order order = orderRepository.findById(orderInput.getIdx())
				.orElseGet(() -> new Order());
		
		Order newOrder = (Order) reflectionUtil.overWriteProperties(order, orderInput);
		
		return orderRepository.save(newOrder);
		
	}

}
