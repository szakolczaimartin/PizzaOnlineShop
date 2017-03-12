package com.pizzashop.UsersDetails.dao;

import com.pizzashop.Users.entity.Users;
import com.pizzashop.UsersDetails.entity.UsersDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    public void removeUserDetails(java.lang.String userName) {
        Session session = sessionFactory.openSession();
        List<Users> userses = session.createQuery("select  i from Users i where i.username = '" + userName + "'").list();
        UsersDetails usersDetails = userses.get(0).getUsersDetails();
        session.delete(usersDetails);
        session.flush();
        session.close();
    }

    @Transactional
    public List<UsersDetails> listbyUsername(java.lang.String valaki) {


        Session session = sessionFactory.getCurrentSession();
        List itemses = session.createQuery("select  i from UsersDetails i where i.username = '" + valaki + "'").list();
        return itemses;
    }
}
