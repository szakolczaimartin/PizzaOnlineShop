package com.pizzashop.UserRoles.dao;

import com.pizzashop.UserRoles.entity.UserRoles;
import com.pizzashop.Users.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserRolesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<UserRoles> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List userRoles = session.createQuery("from UserRoles").list();
        return userRoles;
    }

    @Transactional
    public List<UserRoles> findAdmin() {
        String admin="ADMIN";
        Session session = sessionFactory.getCurrentSession();
        List<UserRoles> userRoles = session.createQuery("select  i from UserRoles i where i.userRole = '" + admin + "'").list();
        return userRoles;
    }


    public void save(UserRoles userRoles)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(userRoles);
        currenSession.flush();
        currenSession.close();
    }

    public void removeUserRole(java.lang.String userName) {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("select  i from User i where i.username = '" + userName + "'").list();
        List<UserRoles> userRoles = users.get(0).getUserRoles();
        for (UserRoles var: userRoles) {
            session.delete(var);
        }
        session.flush();
        session.close();
    }
}
