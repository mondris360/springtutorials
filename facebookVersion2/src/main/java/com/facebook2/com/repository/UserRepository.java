package com.facebook2.com.repository;

import com.facebook2.com.entities.Post;
import com.facebook2.com.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.From;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    User findByUserID(Long userID);
    User findUserByEmail(String email);

//    @Query("SELECT u.firstName, p.postID, p.message, p.timestamp, p.totalLikes From User u JOIN u.posts p")
    List<Post> getUserPostsById(Long userID);

}
