/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.controllers;

import com.vk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vk.pojos.Cart;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Admin
 */
@RestController
public class ApiCartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/api/cart")
    public ResponseEntity<String> addCart(@Valid @RequestBody Cart cart, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Validation Error", HttpStatus.BAD_REQUEST);
        }

        if (cartService.addOrUpdateCart(cart)) {
            return new ResponseEntity<>("Cart added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to add cart", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/cart/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") int id) {
        Cart cart = cartService.getCartById(id);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/api/cart/user/{id}")
    public ResponseEntity<List<Cart>> getCartByUserId(@PathVariable("id") int id) {
        List<Cart> cartList = cartService.getCartByUserId(id);
        if (cartList == null || cartList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @DeleteMapping("/api/cart/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") int id) {
        boolean deleted = cartService.deleteCart(id);
        if (deleted) {
            return new ResponseEntity<>("Cart deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete cart", HttpStatus.NOT_FOUND);
        }
    }
}
