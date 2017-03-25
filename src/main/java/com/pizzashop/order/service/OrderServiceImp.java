package com.pizzashop.order.service;

import com.pizzashop.order.dao.OrderDao;
import com.pizzashop.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao dao;

    public void save(Order order) {
        dao.save(order);
    }

    public Order getOrderById(int id) {
        return dao.getOrderById(id);
    }

    public List<Order> getOrdesByUsername(String username) {
        return dao.orderByUsername(username);
    }

    public List<Order> findAll() {
        return dao.findAll();
    }
}
