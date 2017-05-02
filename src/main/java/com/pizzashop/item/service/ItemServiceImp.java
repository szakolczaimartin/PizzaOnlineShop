package com.pizzashop.item.service;


import com.pizzashop.item.dao.ItemDao;
import com.pizzashop.item.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemDao dao;

    public void save(Item item) {
        dao.save(item);
    }

    public List<Item> findAll() {
        return dao.findAll();
    }

    public void removeItemByFood(String id) {
        dao.removeItemByFood(id);
    }

    public Item getItemById(int id) {
        return dao.getItemById(id);
    }

    public void removeItem(int id) {
        dao.removeItem(id);
    }
}
