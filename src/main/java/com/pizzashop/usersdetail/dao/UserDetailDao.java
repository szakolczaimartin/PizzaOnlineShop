package com.pizzashop.usersdetail.dao;

import com.pizzashop.user.entity.User;
import com.pizzashop.usersdetail.entity.UsersDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(UsersDetail usersDetail)
    {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(usersDetail);
        currenSession.flush();
        currenSession.close();
    }


    public void removeUserDetails(java.lang.String userName) {
        Session session = sessionFactory.openSession();
        List<User> userses = session.createQuery("select  i from User i where i.username = '" + userName + "'").list();
        UsersDetail usersDetail = userses.get(0).getUsersDetail();
        session.delete(usersDetail);
        session.flush();
        session.close();
    }

    @Transactional
    public List<UsersDetail> listbyUsername(java.lang.String valaki) {


        Session session = sessionFactory.getCurrentSession();
        List itemses = session.createQuery("select  i from UsersDetail i where i.username = '" + valaki + "'").list();
        return itemses;
    }
}
