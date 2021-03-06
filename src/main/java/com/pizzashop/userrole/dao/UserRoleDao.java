package com.pizzashop.userrole.dao;

import com.pizzashop.userrole.entity.UserRole;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRoleDao {

    List<UserRole> findAll();

    void save(UserRole userRole);

    void removeUserRoleByUsername(String userName);

    UserRole getUserRoleById(int id);

    void removeUserRoleByID(int id);
}
