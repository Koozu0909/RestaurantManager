/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository;

import java.util.List;
import com.vk.pojos.Category;

/**
 *
 * @author Admin
 */
public interface CategoryRepository {
    List<Category> getCategories();
     boolean addOrUpdateCategory(Category c);
     boolean deleteCategory(int id);
     Category getCategoryById(int id);
}
