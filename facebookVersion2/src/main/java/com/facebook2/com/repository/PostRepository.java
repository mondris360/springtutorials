package com.facebook2.com.repository;

import com.facebook2.com.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    List<Post> findAllByUserID(long userID);
    Post  save(Post post);
//    void deleteById(long postID);
//    Post findByPostID(long PostID);


}
