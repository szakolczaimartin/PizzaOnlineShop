package com.pizzashop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "USERNAME", nullable = false)
    private Users users;

    private Date date;
    private Boolean shipped;

    public Order() {
    }

    public Order(Users users, Date date, Boolean shipped) {
        this.users = users;
        this.date = date;
        this.shipped = shipped;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getShipped() {
        return shipped;
    }

    public void setShipped(Boolean shipped) {
        this.shipped = shipped;
    }
}