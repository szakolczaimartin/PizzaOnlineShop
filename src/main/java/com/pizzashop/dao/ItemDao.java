package com.pizzashop.dao;

import com.pizzashop.entity.Food;
import com.pizzashop.entity.Item;
import com.pizzashop.entity.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public List<Item> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List items = session.createQuery("from Item").list();
        return items;
    }

    public void removeUserDetails(java.lang.String id) {
        Session session = sessionFactory.openSession();
        List<Food> foods = session.createQuery("select  i from Food i where i.id = '" + id + "'").list();
        List<Item> items = foods.get(0).getItem();
        for (Item var: items) {
            session.delete(var);
        }
        session.flush();
        session.close();
    }

}
