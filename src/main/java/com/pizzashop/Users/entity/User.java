package com.pizzashop.Users.entity;


import com.pizzashop.Order.entity.Order;
import com.pizzashop.UserRoles.entity.UserRoles;
import com.pizzashop.UsersDetails.entity.UsersDetails;

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

    @OneToOne
    @PrimaryKeyJoinColumn
    private UsersDetails usersDetails;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<UserRoles> userRoles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Order> orders;


    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, boolean enabled, UsersDetails usersDetails) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.usersDetails = usersDetails;
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

    public UsersDetails getUsersDetails() {
        return usersDetails;
    }

    public void setUsersDetails(UsersDetails usersDetails) {
        this.usersDetails = usersDetails;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }
}
