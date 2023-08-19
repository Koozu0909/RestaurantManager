/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository;

import java.util.List;
import com.vk.pojos.Cart;

/**
 *
 * @author Admin
 */
public interface CartRepository {

    boolean addOrUpdateCart(Cart c);

    boolean deleteCart(int id);

    Cart getCartById(int id);

    List<Cart> getCartByUserId(int id);

}
