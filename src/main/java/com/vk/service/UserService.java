/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service;

import com.vk.pojos.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface UserService extends UserDetailsService {

    List<User> getUsers();

    User addUser(User c);

    boolean deleteUser(int id);

    User getUserById(int id);
    
     User getUserByUsername(String username);
     
      boolean authUser(String username, String password);
     

}
