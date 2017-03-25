package com.pizzashop.food.dao;

import com.pizzashop.food.entity.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class FoodDaoImp implements FoodDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void save(Food food) {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(food);
        currenSession.flush();
        currenSession.close();
    }

    @Transactional
    public List<Food> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List foods = session.createQuery("from Food").list();
        return foods;
    }

    @Transactional
    public Food getFoodById(int id) {
        Session currenSession = sessionFactory.openSession();
        Food food = (Food) currenSession.get(Food.class, new Integer(id));
        currenSession.close();
        return food;
    }

    public void removeFood(int id) {
        Food food = getFoodById(id);
        Session session = sessionFactory.openSession();
        session.delete(food);
        session.flush();
        session.close();
    }

    @Transactional
    public List<Food> foodByName(String username) {

        Session session = sessionFactory.getCurrentSession();
        List foods = session.createQuery("select  i from Food i where i.name = '" + username + "'").list();
        return foods;
    }

}
