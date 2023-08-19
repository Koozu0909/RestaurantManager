/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service.impl;

import com.vk.pojos.User;
import com.vk.repository.UserRepository;
import com.vk.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository categoryRepository;

    @Override
    public List<User> getUsers() {
        return this.categoryRepository.getUsers();
    }

    @Override
    public boolean addOrUpdateUser(User c) {
        return this.categoryRepository.addOrUpdateUser(c);
    }

    @Override
    public boolean deleteUser(int id) {
        return this.categoryRepository.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return this.categoryRepository.getUserById(id);

    }
}
