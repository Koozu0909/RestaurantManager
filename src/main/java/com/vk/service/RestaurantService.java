/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service;

import com.vk.pojos.Restaurant;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RestaurantService {

    List<Restaurant> getRestaurants();

    boolean addOrUpdateRestaurant(Restaurant c);

    boolean deleteRestaurant(int id);

    Restaurant getRestaurantById(int id);
   Restaurant getRestaurantByUserId(int userId);
}
