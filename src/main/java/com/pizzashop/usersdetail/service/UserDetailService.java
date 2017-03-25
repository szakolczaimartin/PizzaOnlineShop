package com.pizzashop.usersdetail.service;


import com.pizzashop.usersdetail.entity.UsersDetail;

import java.util.List;

public interface UserDetailService {

    void save(UsersDetail usersDetail);

    void removeUserDetails(String userName);

    List<UsersDetail> listbyUsername(String username);
}
