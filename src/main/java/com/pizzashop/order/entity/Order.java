package com.pizzashop.order.entity;

import com.pizzashop.user.entity.User;
import com.pizzashop.item.entity.Item;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FOOD_ORDER")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USERNAME", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> items;

    private Date date;
    private Boolean shipped;
    private Boolean ordered;
    private int price;

    public Order() {
    }

    public Order(User user, Date date, Boolean shipped, Boolean ordered, int price) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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