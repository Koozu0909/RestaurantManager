/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.controllers;

import com.vk.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vk.pojos.FoodItem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
public class ApiFoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/api/fooditems")
    public ResponseEntity<List<FoodItem>> listCategories() {
        List<FoodItem> fooditems = this.foodItemService.getFoodItems();
        return new ResponseEntity<>(fooditems, HttpStatus.OK);
    }

    
    @PostMapping("/api/fooditems")
    @Transactional
    public ResponseEntity<FoodItem> addFoodItem(@Valid FoodItem fooditem, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = "D:\\All Project\\Java\\RestaurantManager\\src\\main\\resources\\images\\" + fileName;
            file.transferTo(new File(filePath));
            fooditem.setImageURL("http://localhost:8080/RestaurantManager/api/fooditems/image/" + fileName);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (foodItemService.addOrUpdateFoodItem(fooditem)) {
            return new ResponseEntity<>(fooditem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/fooditems/{id}")
    public ResponseEntity<FoodItem> getFoodItem(@PathVariable("id") Integer id) {
        FoodItem foodItem = foodItemService.getFoodItemById(id);
        if (foodItem != null) {
            return new ResponseEntity<>(foodItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/fooditems/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get("D:/All Project/Java/RestaurantManager/src/main/resources/images/" + imageName);

        byte[] imageBytes = Files.readAllBytes(imagePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Set the correct content type

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/api/fooditems/category/{id}")
    public ResponseEntity<List<FoodItem>> getCartByUserId(@PathVariable("id") int id) {
        List<FoodItem> foodList = foodItemService.getFoodItemsByCategoryId(id);
        if (foodList == null || foodList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

    @DeleteMapping("/api/fooditems/{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable("id") int id) {
        boolean deleted = foodItemService.deleteFoodItem(id);
        if (deleted) {
            return new ResponseEntity<>("FoodItem deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete category", HttpStatus.NOT_FOUND);
        }
    }
}
