package com.pizzashop.order.service;

import com.pizzashop.order.entity.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    Order getOrderById(int id);

    List<Order> getOrdesByUsername(String username);

    List<Order> findAll();
}
