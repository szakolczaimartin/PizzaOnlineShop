package com.pizzashop.userrole.service;


import com.pizzashop.userrole.entity.UserRole;

import java.util.List;

public interface UserRoleService {

     List<UserRole> findAll();

     void save(UserRole userRole);

     void removeUserRoleByUsername(String userName);

     UserRole getUserRoleById(int id);

     void removeUserRoleByID(int id);
}
