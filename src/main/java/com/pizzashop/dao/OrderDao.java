package com.pizzashop.dao;

import com.pizzashop.entity.Item;
import com.pizzashop.entity.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.pizzashop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Order order)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(order);
        currenSession.close();
    }

    @Transactional
    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List orders = session.createQuery("from Order").list();
        return orders;
    }
}
