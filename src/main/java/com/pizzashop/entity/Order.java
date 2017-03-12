package com.pizzashop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USERNAME", nullable = false)
    private Users users;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> items;

    private Date date;
    private Boolean shipped;
    private Boolean ordered;
    private int price;

    public Order() {
    }

    public Order(Users users, Date date, Boolean shipped,Boolean ordered, int price) {
        this.users = users;
        this.date = date;
        this.shipped = shipped;
        this.ordered = ordered;
        this.price = price;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}