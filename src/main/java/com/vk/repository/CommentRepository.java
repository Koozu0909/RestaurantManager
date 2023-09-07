/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.repository;

import java.util.List;
import com.vk.pojos.Comment;

/**
 *
 * @author Admin
 */
public interface CommentRepository {
    List<Comment> getCommentsByFoodItemId(int id);

    boolean addOrUpdateComment(Comment c);

    boolean deleteComment(int id);

    Comment getCommentById(int id);

    List<Comment> getCommentByUserId(int id);

}
