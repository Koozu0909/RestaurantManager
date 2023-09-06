/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service.impl;

import com.vk.pojos.Restaurant;
import com.vk.repository.RestaurantRepository;
import com.vk.service.RestaurantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository categoryRepository;

    @Override
    public List<Restaurant> getRestaurants() {
        return this.categoryRepository.getRestaurants();
    }

    @Override
    public boolean addOrUpdateRestaurant(Restaurant c) {
        return this.categoryRepository.addOrUpdateRestaurant(c);
    }

    @Override
    public boolean deleteRestaurant(int id) {
        return this.categoryRepository.deleteRestaurant(id);
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return this.categoryRepository.getRestaurantById(id);

    }

    @Override
    public Restaurant getRestaurantByUserId(int userId) {
                return this.categoryRepository.getRestaurantByUserId(userId);

    }

}
