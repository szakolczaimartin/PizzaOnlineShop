package com.pizzashop.user.service;


import com.pizzashop.user.dao.UserDao;
import com.pizzashop.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao dao;

    public void save(User user) {
        dao.save(user);
    }

    public User userByUsername(String username) {
        return dao.userByUsername(username);
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public void removeUser(String userName) {
        dao.removeUser(userName);
    }
}
