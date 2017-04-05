package com.pizzashop.userdetails;

import com.pizzashop.food.entity.Food;
import com.pizzashop.user.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(UserDetails usersDetail) {
        Session currenSession = sessionFactory.openSession();
        currenSession.saveOrUpdate(usersDetail);
        currenSession.flush();
        currenSession.close();
    }

    public void removeUserDetails(String userName) {
        Session session = sessionFactory.openSession();
        List<User> userses = session.createQuery("select  i from User i where i.username = '" + userName + "'").list();
        UserDetails usersDetail = userses.get(0).getUserDet();
        session.delete(usersDetail);
        session.flush();
        session.close();
    }

    @Transactional
    public UserDetails getDetailById(int id) {
        Session currenSession = sessionFactory.openSession();
        UserDetails userDetails = (UserDetails) currenSession.get(UserDetails.class, new Integer(id));
        currenSession.close();
        return userDetails;
    }

    public void removeUserDetailById(int id) {
        UserDetails userDetails = getDetailById(id);
        Session session = sessionFactory.openSession();
        session.delete(userDetails);
        session.flush();
        session.close();
    }

    @Transactional
    public List<UserDetails> listbyUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        List itemses = session.createQuery("select  i from UserDetails i where i.name = '" + username + "'").list();
        return itemses;
    }
}
