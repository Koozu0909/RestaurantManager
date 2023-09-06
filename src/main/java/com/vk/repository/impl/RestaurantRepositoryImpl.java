/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository.impl;

import com.vk.pojos.Restaurant;
import com.vk.repository.RestaurantRepository;
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
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Restaurant> getRestaurants() {
        Session s = factory.getObject().getCurrentSession();
        Query<Restaurant> q = s.createQuery("From Restaurant", Restaurant.class);
        List<Restaurant> categories = q.getResultList();
        return categories;
    }
    

    @Override
    public boolean addOrUpdateRestaurant(Restaurant c) {
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
    public Restaurant getRestaurantById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Restaurant.class, id);
    }

    
     @Override
    public boolean deleteRestaurant(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Restaurant c = this.getRestaurantById(id);
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
public Restaurant getRestaurantByUserId(int userId) {
    Session s = this.factory.getObject().getCurrentSession();
    Query<Restaurant> q = s.createQuery("FROM Restaurant r WHERE r.userId = :userId", Restaurant.class);
    q.setParameter("userId", userId);

    try {
        return q.getSingleResult(); // This will return the restaurant associated with the user's ID
    } catch (HibernateException ex) {
        ex.printStackTrace();
        return null;
    }
}


    


}
