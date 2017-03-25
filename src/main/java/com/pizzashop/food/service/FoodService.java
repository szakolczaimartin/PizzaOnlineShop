package com.pizzashop.food.service;


import com.pizzashop.food.entity.Food;

import java.util.List;

public interface FoodService {

    void save(Food food);

    List<Food> findAll();

    Food getFoodById(int id);

    void removeFood(int id);

    List<Food> foodByName(String username);
}
