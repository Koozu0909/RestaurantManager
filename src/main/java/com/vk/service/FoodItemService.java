/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service;

import com.vk.pojos.FoodItem;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface FoodItemService {

    List<FoodItem> getFoodItems();

    List<FoodItem> getFoodItemsByCategoryId(int cateId);

    boolean addOrUpdateFoodItem(FoodItem f);

    boolean deleteFoodItem(int id);

    FoodItem getFoodItemById(int id);
    
    List<FoodItem> getFoodItemsByTypeAndLocation(String foodType, String locationFood);

}
