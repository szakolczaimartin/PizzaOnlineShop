package com.pizzashop.userrole.dao;

import com.pizzashop.item.entity.Item;
import com.pizzashop.userrole.entity.UserRole;
import com.pizzashop.user.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserRoleDaoImp implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<UserRole> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List userRoles = session.createQuery("from UserRole").list();
        return userRoles;
    }


    public void save(UserRole userRole)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(userRole);
        currenSession.flush();
        currenSession.close();
    }

    public void removeUserRoleByUsername(String userName) {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("select  i from User i where i.username = '" + userName + "'").list();
        List<UserRole> userRoles = users.get(0).getUserRoles();
        for (UserRole var: userRoles) {
            session.delete(var);
        }
        session.flush();
        session.close();
    }

    @Transactional
    public UserRole getUserRoleById(int id) {
        Session currenSession = sessionFactory.openSession();
        UserRole userRole = (UserRole) currenSession.get(UserRole.class, new Integer(id));
        currenSession.close();
        return userRole;
    }

    public void removeUserRoleByID(int id) {
        UserRole userRole = getUserRoleById(id);
        Session session = sessionFactory.openSession();
        session.delete(userRole);
        session.flush();
        session.close();
    }
}
