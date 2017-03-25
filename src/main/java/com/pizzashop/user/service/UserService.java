package com.pizzashop.user.service;


import com.pizzashop.user.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User userByUsername(String username);

    List<User> findAll();

    void removeUser(String userName);
}
