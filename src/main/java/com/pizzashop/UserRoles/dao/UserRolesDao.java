package com.pizzashop.UserRoles.dao;

import com.pizzashop.UserRoles.entity.UserRole;
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
    public List<UserRole> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List userRoles = session.createQuery("from UserRole").list();
        return userRoles;
    }

    @Transactional
    public List<UserRole> findAdmin() {
        String admin="ADMIN";
        Session session = sessionFactory.getCurrentSession();
        List<UserRole> userRoles = session.createQuery("select  i from UserRole i where i.userRole = '" + admin + "'").list();
        return userRoles;
    }


    public void save(UserRole userRole)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(userRole);
        currenSession.flush();
        currenSession.close();
    }

    public void removeUserRole(java.lang.String userName) {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("select  i from User i where i.username = '" + userName + "'").list();
        List<UserRole> userRoles = users.get(0).getUserRoles();
        for (UserRole var: userRoles) {
            session.delete(var);
        }
        session.flush();
        session.close();
    }
}
