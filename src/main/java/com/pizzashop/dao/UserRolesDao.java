package com.pizzashop.dao;

import com.pizzashop.entity.UserRoles;
import com.pizzashop.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public void removeUserRole(java.lang.String userName) {
        Session session = sessionFactory.openSession();
        List<Users> users = session.createQuery("select  i from Users i where i.username = '" + userName + "'").list();
        List<UserRoles> userRoles = users.get(0).getUserRoles();
        for (UserRoles var: userRoles) {
            session.delete(var);
        }
        session.flush();
        session.close();
    }
}
