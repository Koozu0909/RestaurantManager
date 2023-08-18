/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service;

import com.vk.pojos.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CategoryService {

    List<Category> getCategories();

    boolean addOrUpdateCategory(Category c);

    boolean deleteCategory(int id);

    Category getCategoryById(int id);

}
