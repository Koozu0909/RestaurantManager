/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository.impl;

import com.vk.pojos.User;
import com.vk.repository.UserRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<User> getUsers() {
        Session s = factory.getObject().getCurrentSession();
        Query<User> q = s.createQuery("From User", User.class);
        List<User> categories = q.getResultList();
        return categories;
    }

    @Override
    public User addUser(User c) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(c);
        return c;
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);

        return (User) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public boolean deleteUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        User c = this.getUserById(id);
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query<Long> q = s.createQuery("SELECT COUNT(*) FROM User WHERE username = :un", Long.class);
        q.setParameter("un", username);

        Long count = q.uniqueResult();
        return count > 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User updateUser(User user) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            // Retrieve the user by their ID first
            User existingUser = session.get(User.class, user.getId());

            if (existingUser != null) {
                // Update the properties of the existing user with the values from updatedUser
                existingUser.setLastName(user.getLastName());
                existingUser.setFirstName(user.getFirstName());
                existingUser.setPhone(user.getPhone());
                existingUser.setEmail(user.getEmail());
                existingUser.setImageURL(user.getImageURL());

                // Update other properties as needed
                session.beginTransaction();
                session.update(existingUser); // Update the user in the database
                session.getTransaction().commit();

                return existingUser;
            } else {
                // User with the provided ID does not exist
                return null;
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    


}
