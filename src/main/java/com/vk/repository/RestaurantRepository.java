/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository;

import java.util.List;
import com.vk.pojos.Restaurant;

/**
 *
 * @author Admin
 */
public interface RestaurantRepository {
    List<Restaurant> getRestaurants();
     boolean addOrUpdateRestaurant(Restaurant c);
     boolean deleteRestaurant(int id);
     Restaurant getRestaurantById(int id);
}
