package com.pizzashop.entity;


import javax.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {


    @Id
    @GeneratedValue
    private int id;


    private String name;
    private double price;

    public Pizza() {
    }

    public Pizza(String name, Double price) {
        this.name = name;
        this.price= price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}