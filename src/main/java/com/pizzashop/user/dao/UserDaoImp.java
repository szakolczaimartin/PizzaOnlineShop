package com.pizzashop.user.dao;

import com.pizzashop.user.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(user);
        currenSession.flush();
        currenSession.close();
    }

    @Transactional
    public User userByUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("select  i from User i where i.username = '" + username + "'").list();

        if (userList.get(0) == null)
        {
            return null;
        }
        else {
            User user = userList.get(0);
            return user;
        }
    }

    @Transactional
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List users = session.createQuery("from User").list();
        return users;
    }

    public void removeUser(java.lang.String userName) {
        Session session = sessionFactory.openSession();
        List<User> userses = session.createQuery("select  i from User i where i.username = '" + userName + "'").list();
        User user = userses.get(0);
        session.delete(user);
        session.flush();
        session.close();
    }

}
