package com.pizzashop.item.service;

import com.pizzashop.item.entity.Item;

import java.util.List;

public interface ItemService {

    void save(Item item);

    List<Item> findAll();

    void removeItemsFood(java.lang.String id);

    Item getItemById(int id);

    void removeItem(int id);
}
