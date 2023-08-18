/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.controllers;

import com.vk.pojos.Category;
import com.vk.service.CategoryService;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categories",this.categoryService.getCategories());
        return "index";
    }

    
    public static void main(String[] args) {
        File directory = new File("src\\main\\resources\\images");
        if (directory.canWrite()) {
            System.out.println("Application can write to directory");
        } else {
            System.out.println("Application cannot write to directory");
        }
    }
}
