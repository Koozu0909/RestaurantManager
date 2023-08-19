/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository;

import java.util.List;
import com.vk.pojos.FoodItem;

/**
 *
 * @author Admin
 */
public interface FoodItemRepository {
    List<FoodItem> getFoodItems();
       List<FoodItem> getFoodItemsByCategoryId(int cateId);
     boolean addOrUpdateFoodItem(FoodItem f);
     boolean deleteFoodItem(int id);
     FoodItem getFoodItemById(int id);
}
