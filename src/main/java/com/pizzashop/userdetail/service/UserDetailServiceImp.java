package com.pizzashop.userdetail.service;


import com.pizzashop.userdetail.dao.UserDetailDao;
import com.pizzashop.userdetail.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImp implements UserDetailService {


    @Autowired
    private UserDetailDao dao;

    public void save(UserDetail usersDetail) {
        dao.save(usersDetail);
    }

    public void removeUserDetails(String userName) {
        dao.removeUserDetails(userName);
    }

    public UserDetail getDetailById(int id) {
        return dao.getDetailById(id);
    }

    public void removeUserDetailById(int id) {
        dao.removeUserDetailById(id);
    }

    public List<UserDetail> listbyUsername(String username) {
        return dao.listbyUsername(username);
    }
}
