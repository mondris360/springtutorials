package com.facebook.com.repository;

import com.facebook.com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {
}
