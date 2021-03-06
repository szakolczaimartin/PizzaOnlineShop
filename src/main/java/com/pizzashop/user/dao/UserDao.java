package com.pizzashop.user.dao;


import com.pizzashop.user.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User userByUsername(String username);

    List<User> findAll();

    void removeUser(String userName);
}
