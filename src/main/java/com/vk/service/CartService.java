/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service;

import com.vk.pojos.Cart;
import com.vk.pojos.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CartService {

       boolean addOrUpdateCart(Cart c);

    boolean deleteCart(int id);

    Cart getCartById(int id);

    List<Cart> getCartByUserId(int id);

}
