package com.pizzashop.food.dao;


import com.pizzashop.food.entity.Food;

import java.util.List;

public interface FoodDao {

    void save(Food food);

    List<Food> findAll();

    Food getFoodById(int id);

    void removeFood(int id);

    List<Food> foodByName(String username);
}
