package com.pizzashop.dao;

import com.pizzashop.entity.Item;
import com.pizzashop.entity.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Item item)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(item);
        currenSession.close();
    }
}
