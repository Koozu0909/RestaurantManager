/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service.impl;

import com.vk.pojos.Cart;
import com.vk.repository.CartRepository;
import com.vk.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository categoryRepository;

    @Override
    public boolean addOrUpdateCart(Cart c) {
        return this.categoryRepository.addOrUpdateCart(c);
    }

    @Override
    public boolean deleteCart(int id) {
        return this.categoryRepository.deleteCart(id);
    }

    @Override
    public Cart getCartById(int id) {
        return this.categoryRepository.getCartById(id);

    }
    
     @Override
    public List<Cart> getCartByUserId(int id) {
        return this.categoryRepository.getCartByUserId(id);

    }
}
