package com.pizzashop.dao;

import com.pizzashop.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UsersDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void save(Users users)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(users);
        currenSession.close();
    }
}
