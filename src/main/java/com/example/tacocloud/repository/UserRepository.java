package com.example.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.tacocloud.model.User;


public interface UserRepository  extends CrudRepository<User,Long> {
    User findByUsername(String username);    
}
