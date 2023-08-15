package com.example.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.tacocloud.model.User;


public interface UserRepository  extends CrudRepository<User,Long> {
    UserDetails findByUsername(String username);    
}
