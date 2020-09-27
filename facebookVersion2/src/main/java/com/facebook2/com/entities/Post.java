package com.facebook2.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="posts")
public class Post {

    Timestamp timestamp =  new Timestamp(System.currentTimeMillis());

    // overloaded constructor to create new post

        // contructor to create a new post
    public Post(User user, String message) {
        this.user = user;
        this.message = message;
    }
    // contructor to update a post


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postID;
    @ManyToMany
    @JoinColumn(name="userID")
    private User user;

    @Column(name="message")
    @NotBlank(message = "post message  is compulsory")
    private String message;

    @Column(name="deleted")
    private String deleted = "false";
    private Timestamp date = timestamp;

    private int totalLikes = 0;

//    // link the post table and the likes table together
    @OneToMany(targetEntity = Like.class, cascade = CascadeType.ALL)
    @JoinColumn(name="postID_FK",  = "postID")
    List<Like> likes =  new ArrayList<>();



}
