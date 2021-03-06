package com.pizzashop.order.dao;

import com.pizzashop.order.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderDaoImp implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Order order) {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(order);
        currenSession.flush();
        currenSession.close();
    }

    @Transactional
    public Order getOrderById(int id) {
        Session currenSession = sessionFactory.openSession();
        Order order = (Order) currenSession.get(Order.class, new Integer(id));
        currenSession.close();
        return order;
    }

    @Transactional
    public List<Order> orderByUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        List<Order> orderList = session.createQuery("select  i from Order i").list();

        if (orderList != null) {
            return orderList;
        }

        return null;
    }

    @Transactional
    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List orders = session.createQuery("from Order").list();
        return orders;
    }
}
