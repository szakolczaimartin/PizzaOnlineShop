package com.pizzashop.order.dao;


import com.pizzashop.order.entity.Order;

import java.util.List;

public interface OrderDao {

    void save(Order order);

    Order getOrderById(int id);

    List<Order> orderByUsername(String username);

    List<Order> findAll();
}
