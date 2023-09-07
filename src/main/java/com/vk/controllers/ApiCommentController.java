/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.controllers;

import com.vk.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vk.pojos.Comment;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Admin
 */
@RestController
public class ApiCommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/api/comment/fooditem/{id}")
    @CrossOrigin
    public ResponseEntity<List<Comment>> listCommentsByFoodItemId(@PathVariable("id") int id) {
        List<Comment> comments = this.commentService.getCommentsByFoodItemId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/api/comment")
    @CrossOrigin
    public ResponseEntity<Comment> addComment(@Valid @RequestBody Comment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (commentService.addOrUpdateComment(comment)) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/comment/{id}")
    @CrossOrigin
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") int id) {
        Comment comment = commentService.getCommentById(id);
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping("/api/comment/user/{id}")
    @CrossOrigin
    public ResponseEntity<List<Comment>> getCommentByUserId(@PathVariable("id") int id) {
        List<Comment> commentList = commentService.getCommentByUserId(id);
        if (commentList == null || commentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @DeleteMapping("/api/comment/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteComment(@PathVariable("id") int id) {
        boolean deleted = commentService.deleteComment(id);
        if (deleted) {
            return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete comment", HttpStatus.NOT_FOUND);
        }
    }
}
