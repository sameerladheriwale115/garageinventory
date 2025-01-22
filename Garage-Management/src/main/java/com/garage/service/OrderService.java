package com.garage.service;

import java.util.List;

import com.garage.domain.Order;

public interface OrderService {
	List<Order> getAllOrders();
    Order saveOrder(Order order);
    Order getOrderById(int id);
    void deleteOrder(int id);
}
