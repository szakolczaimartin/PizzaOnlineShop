package com.pizzashop.item.dao;

import com.pizzashop.item.entity.Item;

import java.util.List;

public interface ItemDao {

    void save(Item item);

    List<Item> findAll();

    void removeItemByFood(String id);

    Item getItemById(int id);

    void removeItem(int id);
}
