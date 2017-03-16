package com.pizzashop.userrole.entity;


import com.pizzashop.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USERNAME", nullable = false)
    private User user;

    @Column(name = "USER_ROLE" ,  nullable = false)
    private String userRole ;

    public UserRole(){}

    public UserRole(User user, String userRole){
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
