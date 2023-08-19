/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository;

import java.util.List;
import com.vk.pojos.User;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    List<User> getUsers();
     boolean addOrUpdateUser(User c);
     boolean deleteUser(int id);
     User getUserById(int id);
}
