package com.pizzashop.UserRoles.entity;


import com.pizzashop.Users.entity.Users;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USERNAME", nullable = false)
    private Users users;

    @Column(name = "USER_ROLE" ,  nullable = false)
    private String userRole ;

    public UserRoles(){}

    public UserRoles(Users users, String userRole){
        this.users= users;
        this.userRole = userRole;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
