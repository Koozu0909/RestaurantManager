/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository.impl;

import com.vk.pojos.FoodItem;
import com.vk.repository.FoodItemRepository;
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
public class FoodItemRepositoryImpl implements FoodItemRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<FoodItem> getFoodItems() {
        Session session = factory.getObject().getCurrentSession();
        Query<FoodItem> query = session.createQuery("FROM FoodItem", FoodItem.class);
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateFoodItem(FoodItem foodItem) {
        Session session = factory.getObject().getCurrentSession();
        try {
            if (foodItem.getId() == null) {
                session.save(foodItem);
            } else {
                session.update(foodItem);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Log the error or handle it appropriately
            throw new RuntimeException("Failed to add or update the food item", ex);
        }
    }

    @Override
    public FoodItem getFoodItemById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(FoodItem.class, id);
    }

    @Override
    public boolean deleteFoodItem(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        FoodItem c = this.getFoodItemById(id);
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FoodItem> getFoodItemsByCategoryId(int cateId) {
        Session session = this.factory.getObject().getCurrentSession();
        Query<FoodItem> query = session.createQuery("FROM FoodItem f WHERE f.categoryId = :cateId", FoodItem.class);
        query.setParameter("cateId", cateId);
        return query.list();
    }
    
     @Override
    public List<FoodItem> getFoodItemsByTypeAndLocation(String foodType, String locationFood) {
        Session session = factory.getObject().getCurrentSession();
        Query<FoodItem> query = session.createQuery("FROM FoodItem f WHERE f.foodType = :foodType AND f.locationFood = :locationFood", FoodItem.class);
        query.setParameter("foodType", foodType);
        query.setParameter("locationFood", locationFood);
        return query.getResultList();
    }

}
