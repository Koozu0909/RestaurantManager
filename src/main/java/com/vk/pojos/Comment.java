/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vk.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Comment", columnDefinition = "TEXT")
    private String comment;
    
    @Column(name = "UserComment")
    private String userComment;


    @Column(name = "Rate")
    private Double rate;
    
     @Column(name = "CommentDate")
    private Date commentDate;

    @Column(name = "UserImageURL")
    private String userImageURL;

    @Column(name = "FoodItemId")
    private Integer foodItemId;

    @Column(name = "UserId")
    private Integer userId;

    public Comment() {
    }
    public Comment(Integer id, String comment, String userComment, Double rate, Date commentDate, String userImageURL, Integer foodItemId, Integer userId) {
        this.id = id;
        this.comment = comment;
        this.userComment = userComment;
        this.rate = rate;
        this.commentDate = commentDate;
        this.userImageURL = userImageURL;
        this.foodItemId = foodItemId;
        this.userId = userId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public Integer getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Integer foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
        public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }


 
}
