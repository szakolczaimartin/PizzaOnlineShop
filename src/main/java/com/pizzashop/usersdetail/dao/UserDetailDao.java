package com.pizzashop.usersdetail.dao;


import com.pizzashop.usersdetail.entity.UsersDetail;

import java.util.List;

public interface UserDetailDao {

    void save(UsersDetail usersDetail);

    void removeUserDetails(String userName);

    List<UsersDetail> listbyUsername(String username);
}
