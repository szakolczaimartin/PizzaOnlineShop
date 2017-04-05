package com.pizzashop.user.entity;


import com.pizzashop.order.entity.Order;
import com.pizzashop.userdetails.UserDetails;
import com.pizzashop.userrole.entity.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USERNAME", unique = true, nullable = false, length = 45)
    private String username;
    @Column(name = "PASSWORD", nullable = false, length = 60)
    private String password;
    @Column(name = "ENABlED", nullable = false)
    private boolean enabled;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_DETAIL")
    private UserDetails userDet;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Order> order;


    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, boolean enabled, UserDetails userDet) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userDet = userDet;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public UserDetails getUserDet() {
        return userDet;
    }

    public void setUserDet(UserDetails userDet) {
        this.userDet = userDet;
    }
}
