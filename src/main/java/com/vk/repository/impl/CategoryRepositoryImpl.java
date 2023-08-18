/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository.impl;

import com.vk.pojos.Category;
import com.vk.repository.CategoryRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Category> getCategories() {
        Session s = factory.getObject().getCurrentSession();
        Query<Category> q = s.createQuery("From Category", Category.class);
        List<Category> categories = q.getResultList();
        return categories;
    }
    

    @Override
    public boolean addOrUpdateCategory(Category c) {
          Session s = this.factory.getObject().getCurrentSession();
        try {
            if (c.getId() == null)
                s.save(c);
            else
                s.update(c);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Category getCategoryById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Category.class, id);
    }

    
     @Override
    public boolean deleteCategory(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Category c = this.getCategoryById(id);
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    


}
