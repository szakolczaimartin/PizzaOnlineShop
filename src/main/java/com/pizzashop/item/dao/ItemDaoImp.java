package com.pizzashop.item.dao;

import com.pizzashop.food.entity.Food;
import com.pizzashop.item.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class ItemDaoImp implements ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Item item) {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(item);
        currenSession.flush();
        currenSession.close();
    }

    @Transactional
    public List<Item> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List items = session.createQuery("from Item").list();
        return items;
    }

    public void removeItemByFood(String id) {
        Session session = sessionFactory.openSession();
        List<Food> foods = session.createQuery("select  i from Food i where i.id = '" + id + "'").list();
        List<Item> items = foods.get(0).getItem();
        for (Item var : items) {
            session.delete(var);
        }
        session.flush();
        session.close();
    }

    @Transactional
    public Item getItemById(int id) {
        Session currenSession = sessionFactory.openSession();
        Item item = (Item) currenSession.get(Item.class, new Integer(id));
        currenSession.close();
        return item;
    }

    public void removeItem(int id) {
        Item item = getItemById(id);
        Session session = sessionFactory.openSession();
        session.delete(item);
        session.flush();
        session.close();
    }
}
