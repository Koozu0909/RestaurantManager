/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository.impl;

import com.vk.pojos.Cart;
import com.vk.pojos.Category;
import com.vk.repository.CartRepository;
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
public class CartRepositoryImpl implements CartRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdateCart(Cart c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (c.getId() == null) {
                s.save(c);
            } else {
                s.update(c);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Cart getCartById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Cart.class, id);
    }

  @Override
public List<Cart> getCartByUserId(int userId) {
    Session session = this.factory.getObject().getCurrentSession();
    Query<Cart> query = session.createQuery("FROM Cart c WHERE c.userId = :userId", Cart.class);
    query.setParameter("userId", userId);

    return query.list();
}


    @Override
    public boolean deleteCart(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Cart c = this.getCartById(id);
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
