package com.pizzashop.userdetail.service;


import com.pizzashop.userdetail.entity.UserDetail;

import java.util.List;

public interface UserDetailService {

    void save(UserDetail usersDetail);

    void removeUserDetailByUsername(String userName);

    UserDetail getDetailById(int id);

    void removeUserDetailById(int id);

    List<UserDetail> listbyUsername(String username);
}
