package com.pizzashop.userrole.dao;

import com.pizzashop.userrole.entity.UserRole;

import java.util.List;


public interface UserRoleDao {

    List<UserRole> findAll();

    List<UserRole> findAdmin();

    void save(UserRole userRole);

    void removeUserRole(String userName);
}
