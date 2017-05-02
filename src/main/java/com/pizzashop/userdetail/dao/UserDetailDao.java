package com.pizzashop.userdetail.dao;

import com.pizzashop.userdetail.entity.UserDetail;

import java.util.List;


public interface UserDetailDao {

    void save(UserDetail usersDetail);

    void removeUserDetailByUsername(String userName);

    UserDetail getDetailById(int id);

    void removeUserDetailById(int id);

    List<UserDetail> listbyUsername(String username);
}
