package com.pizzashop.dao;

import com.pizzashop.entity.UserRoles;
import com.pizzashop.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserRolesDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(UserRoles userRoles)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(userRoles);
        currenSession.flush();
        currenSession.close();
    }
}
