package com.pizzashop.entity;

import javax.persistence.*;

@Entity
@Table(name = "usersDetails")
public class UsersDetails {



    @Id
    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;
    @Column(name = "name", nullable = false, length = 36)
    private String name;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "phoneNumber", nullable = false, length = 100)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "usersDetails", cascade = CascadeType.DETACH)
    private Users users;


    public UsersDetails(){}

    public UsersDetails(String username, String name, String address, String email, String phoneNumber) {
        this.username = username;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public UsersDetails(String username, String name, String address, String email, String phoneNumber, Users users) {
        this.username = username;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.users = users;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
