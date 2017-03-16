package com.pizzashop.UserRoles.entity;


import com.pizzashop.Users.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLES")
public class UserRoles {

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USERNAME", nullable = false)
    private User user;

    @Column(name = "USER_ROLE" ,  nullable = false)
    private String userRole ;

    public UserRoles(){}

    public UserRoles(User user, String userRole){
        this.user = user;
        this.userRole = userRole;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
