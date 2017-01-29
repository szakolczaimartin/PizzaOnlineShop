package com.pizzashop.dao;

import com.pizzashop.entity.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PizzaDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void save(Pizza pizza)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(pizza);
        currenSession.close();
    }
}
