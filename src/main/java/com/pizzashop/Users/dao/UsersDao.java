package com.pizzashop.Users.dao;

import com.pizzashop.Users.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UsersDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void save(Users users)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(users);
        currenSession.flush();
        currenSession.close();
    }

    @Transactional
    public Users userByUsername(java.lang.String valaki) {

        Session session = sessionFactory.getCurrentSession();
        List<Users> userList = session.createQuery("select  i from Users i where i.username = '" + valaki + "'").list();

        if (userList.get(0) == null)
        {
            return null;
        }
        else {
            Users user = userList.get(0);
            return user;
        }
    }

    @Transactional
    public List<Users> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List users = session.createQuery("from Users").list();
        return users;
    }



    public void removeUser(java.lang.String userName) {
        Session session = sessionFactory.openSession();
        List<Users> userses = session.createQuery("select  i from Users i where i.username = '" + userName + "'").list();
        Users user = userses.get(0);
        session.delete(user);
        session.flush();
        session.close();
    }

}
