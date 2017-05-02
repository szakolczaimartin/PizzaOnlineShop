package com.pizzashop.userrole.service;

import com.pizzashop.userrole.dao.UserRoleDao;
import com.pizzashop.userrole.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImp implements UserRoleService {

    @Autowired
    private UserRoleDao dao;

    public List<UserRole> findAll() {
        return dao.findAll();
    }

    public void save(UserRole userRole) {
        dao.save(userRole);
    }

    public void removeUserRoleByUsername(String userName) {
        dao.removeUserRoleByUsername(userName);
    }

    public UserRole getUserRoleById(int id) {
       return dao.getUserRoleById(id);
    }

    public void removeUserRoleByID(int id) {
       dao.removeUserRoleByID(id);
    }
}
