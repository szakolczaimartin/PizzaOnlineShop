package com.pizzashop.userrole.dao;

import com.pizzashop.userrole.entity.UserRole;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRoleDao {

    List<UserRole> findAll();

    List<UserRole> findAdmin();

    void save(UserRole userRole);

    void removeUserRole(String userName);

    UserRole getUserRoleById(int id);

    void removeUserRoleByID(int id);
}
