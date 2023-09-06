/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.controllers;

import com.vk.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vk.pojos.Restaurant;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
public class ApiRestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/api/restaurant")
    @CrossOrigin
    public ResponseEntity<List<Restaurant>> listRestaurant() {
        List<Restaurant> restaurant = this.restaurantService.getRestaurants();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping("/api/restaurant")
    @Transactional
    @CrossOrigin
    public ResponseEntity<String> addRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = "D:\\All Project\\Java\\RestaurantManager\\src\\main\\resources\\images\\restaurant\\" + fileName;
            file.transferTo(new File(filePath));
            restaurant.setImageURL("http://localhost:8080/RestaurantManager/api/restaurant/image/" + fileName);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (restaurantService.addOrUpdateRestaurant(restaurant)) {
            return new ResponseEntity<>("Restaurant added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to add restaurant", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/restaurant/{id}")
    @CrossOrigin
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") int id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    
    @GetMapping("/api/restaurant/image/{imageName}")
    @CrossOrigin
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get("D:/All Project/Java/RestaurantManager/src/main/resources/images/restaurant/" + imageName);
        byte[] imageBytes = Files.readAllBytes(imagePath);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Set the correct content type
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @DeleteMapping("/api/restaurant/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id") int id) {
        boolean deleted = restaurantService.deleteRestaurant(id);
        if (deleted) {
            return new ResponseEntity<>("Restaurant deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete restaurant", HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/api/restaurant/user/{userId}")
    @CrossOrigin
public ResponseEntity<Restaurant> getRestaurantByUserId(@PathVariable("userId") int userId) {
    Restaurant restaurant = restaurantService.getRestaurantByUserId(userId);
    if (restaurant == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(restaurant, HttpStatus.OK);
}

}
