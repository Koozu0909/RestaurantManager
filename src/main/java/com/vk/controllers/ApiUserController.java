/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.controllers;

import com.vk.components.JwtService;
import com.vk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vk.pojos.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> listCategories() {
        List<User> user = this.userService.getUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/update-info-user",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = {"http://localhost:3000"})
public ResponseEntity<?> updateUser(@Valid User user, BindingResult bindingResult, @RequestParam(value = "file", required = false) MultipartFile file) {
    if (bindingResult.hasErrors()) {
        return new ResponseEntity<>("Invalid user data.", HttpStatus.BAD_REQUEST);
    }

    if (file != null && !file.isEmpty()) {
        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = "D:\\All Project\\Java\\RestaurantManager\\src\\main\\resources\\images\\user\\" + fileName;
            file.transferTo(new File(filePath));
            user.setImageURL("http://localhost:8080/RestaurantManager/api/user/image/" + fileName);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to store the image.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    try {
        User updatedUser = userService.updateUserWithNewTransaction(user);
        if (updatedUser == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    } catch (Exception e) {
        return new ResponseEntity<>("Failed to update user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(user, HttpStatus.OK);
}


    @PostMapping(path = "/register")
    @CrossOrigin(origins = {"http://localhost:3000/"})
    public ResponseEntity<String> addUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        if (userService.existsByUsername(username)) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(" ");
        user.setFirstName(" ");
        user.setLastName(" ");
        user.setPhone(" ");
        user.setUsername(username);
        user.setPassword(password);
        user.setActive(true);
        user.setUserRole("ROLE_USER");
        user.setImageURL("http://localhost:8080/RestaurantManager/api/user/image/71dd10fe-ec0a-4b43-bbc8-a68fb0f8e1ff_user white.png");

        userService.addUser(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get("D:/All Project/Java/RestaurantManager/src/main/resources/images/user/" + imageName);
        byte[] imageBytes = Files.readAllBytes(imagePath);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Set the correct content type
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete user", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/current-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = {"http://localhost:3000/"})
    public ResponseEntity<User> details(@RequestBody Map<String, String> requestBody) {
        String token = requestBody.get("token");
        String username = jwtService.getUsernameFromToken(token);
        User u = this.userService.getUserByUsername(username);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

}
