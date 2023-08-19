/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service;

import com.vk.pojos.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserService {

    List<User> getUsers();

    boolean addOrUpdateUser(User c);

    boolean deleteUser(int id);

    User getUserById(int id);

}
