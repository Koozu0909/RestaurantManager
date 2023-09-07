/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository.impl;

import com.vk.pojos.Comment;
import com.vk.pojos.Comment;
import com.vk.repository.CommentRepository;
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
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    
    
    @Override
    public List<Comment> getCommentsByFoodItemId(int id) {
        Session s = factory.getObject().getCurrentSession();
        Query<Comment> q = s.createQuery("From Comment c Where c.foodItemId = :id", Comment.class);
        q.setParameter("id", id);
        List<Comment> categories = q.getResultList();
        return categories;
    }

    @Override
    public boolean addOrUpdateComment(Comment c) {
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
    public Comment getCommentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Comment.class, id);
    }

  @Override
    public List<Comment> getCommentByUserId(int userId) {
    Session session = this.factory.getObject().getCurrentSession();
    Query<Comment> query = session.createQuery("FROM Comment c WHERE c.userId = :userId", Comment.class);
    query.setParameter("userId", userId);

    return query.list();
}


    @Override
    public boolean deleteComment(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Comment c = this.getCommentById(id);
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
