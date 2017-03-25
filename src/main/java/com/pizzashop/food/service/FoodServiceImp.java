package com.pizzashop.food.service;

import com.pizzashop.food.dao.FoodDao;
import com.pizzashop.food.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImp implements FoodService {

    @Autowired
    private FoodDao dao;

    public void save(Food food) {
        dao.save(food);
    }

    public List<Food> findAll() {
        return dao.findAll();
    }

    public Food getFoodById(int id) {
        return dao.getFoodById(id);
    }

    public void removeFood(int id) {
        dao.removeFood(id);
    }

    public List<Food> foodByName(String username) {

        return dao.foodByName(username);
    }

}
