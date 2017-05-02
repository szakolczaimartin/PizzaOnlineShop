package com.pizzashop.userdetail.dao;

import com.pizzashop.user.entity.User;
import com.pizzashop.userdetail.entity.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserDetailDaoImp implements UserDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(UserDetail usersDetail) {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(usersDetail);
        currenSession.flush();
        currenSession.close();
    }

    public void removeUserDetailByUsername(String userName) {
        Session session = sessionFactory.openSession();
        List<User> userses = session.createQuery("select  i from User i where i.username = '" + userName + "'").list();
        UserDetail usersDetail = userses.get(0).getUserDet();
        session.delete(usersDetail);
        session.flush();
        session.close();
    }

    @Transactional
    public UserDetail getDetailById(int id) {
        Session currenSession = sessionFactory.openSession();
        UserDetail userDetail = (UserDetail) currenSession.get(UserDetail.class, new Integer(id));
        currenSession.close();
        return userDetail;
    }

    public void removeUserDetailById(int id) {
        UserDetail userDetail = getDetailById(id);
        Session session = sessionFactory.openSession();
        session.delete(userDetail);
        session.flush();
        session.close();
    }

    @Transactional
    public List<UserDetail> listbyUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        List itemses = session.createQuery("select  i from UserDetails i where i.name = '" + username + "'").list();
        return itemses;
    }
}
