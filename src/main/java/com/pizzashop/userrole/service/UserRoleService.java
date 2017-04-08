package com.pizzashop.userrole.service;


import com.pizzashop.userrole.entity.UserRole;

import java.util.List;

public interface UserRoleService {

     List<UserRole> findAll();

     List<UserRole> findAdmin();

     void save(UserRole userRole);

     void removeUserRole(String userName);

     UserRole getUserRoleById(int id);

     void removeUserRoleByID(int id);
}
