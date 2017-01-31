package com.pizzashop.dao;

import com.pizzashop.entity.Users;
import com.sun.org.apache.xpath.internal.operations.String;
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
    public List<Users> listItemsoOneOrder(java.lang.String valaki) {


        Session session = sessionFactory.getCurrentSession();
        List itemses = session.createQuery("select  i from Users i where i.username = '" + valaki + "'").list();
        return itemses;
    }
}
