package com.pizzashop.food.entity;

import com.pizzashop.item.entity.Item;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FOOD")
public class Food {

    @Id
    @GeneratedValue
    private int id;


    private String name;
    private String url;
    private String ingredients;
    private String type;
    private String size;

    private int price;

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Item> item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
