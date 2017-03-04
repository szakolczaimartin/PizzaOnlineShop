package com.pizzashop.dao;

import com.pizzashop.entity.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.pizzashop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class Orderdao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Order order)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(order);
        currenSession.close();
    }
}
