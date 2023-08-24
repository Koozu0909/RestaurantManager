/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service.impl;

import com.vk.pojos.FoodItem;
import com.vk.repository.FoodItemRepository;
import com.vk.service.FoodItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository categoryRepository;

    @Override
    public List<FoodItem> getFoodItems() {
        return this.categoryRepository.getFoodItems();
    }

    @Override
    public boolean addOrUpdateFoodItem(FoodItem f) {
        return this.categoryRepository.addOrUpdateFoodItem(f);
    }

    @Override
    public boolean deleteFoodItem(int id) {
        return this.categoryRepository.deleteFoodItem(id);
    }

    @Override
    public FoodItem getFoodItemById(int id) {
        return this.categoryRepository.getFoodItemById(id);

    }

    @Override
    public List<FoodItem> getFoodItemsByCategoryId(int cateId) {
        return this.categoryRepository.getFoodItemsByCategoryId(cateId);
    }

    @Override
    public List<FoodItem> getFoodItemsByTypeAndLocation(String foodType, String locationFood) {
        return this.categoryRepository.getFoodItemsByTypeAndLocation(foodType, locationFood);
    }
}
