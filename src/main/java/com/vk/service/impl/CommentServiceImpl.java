/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.service.impl;

import com.vk.pojos.Comment;
import com.vk.repository.CommentRepository;
import com.vk.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository categoryRepository;
    
    @Override
    public List<Comment> getCommentsByFoodItemId(int id) {
        return this.categoryRepository.getCommentsByFoodItemId(id);
    }

    @Override
    public boolean addOrUpdateComment(Comment c) {
        return this.categoryRepository.addOrUpdateComment(c);
    }

    @Override
    public boolean deleteComment(int id) {
        return this.categoryRepository.deleteComment(id);
    }

    @Override
    public Comment getCommentById(int id) {
        return this.categoryRepository.getCommentById(id);

    }
    
     @Override
    public List<Comment> getCommentByUserId(int id) {
        return this.categoryRepository.getCommentByUserId(id);

    }
}
