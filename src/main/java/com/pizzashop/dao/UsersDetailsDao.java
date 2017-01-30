package com.pizzashop.dao;

import com.pizzashop.entity.Users;
import com.pizzashop.entity.UsersDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UsersDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(UsersDetails usersDetails)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(usersDetails);
        currenSession.flush();
        currenSession.close();
    }
}
