package com.pizzashop.usersdetail.service;

import com.pizzashop.usersdetail.dao.UserDetailDao;
import com.pizzashop.usersdetail.entity.UsersDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImp implements UserDetailService {

    @Autowired
    private UserDetailDao dao;

    public void save(UsersDetail usersDetail) {
        dao.save(usersDetail);
    }

    public void removeUserDetails(String userName) {
        dao.removeUserDetails(userName);
    }

    public List<UsersDetail> listbyUsername(String username) {
        return dao.listbyUsername(username);
    }
}
