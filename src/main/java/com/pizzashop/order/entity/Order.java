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

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private int price;

    public Order() {
    }

    public Order(User user, Date date, OrderStatus orderStatus, int price) {
        this.user = user;
        this.date = date;
        this.orderStatus = orderStatus;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}