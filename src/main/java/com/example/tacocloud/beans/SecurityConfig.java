package com.example.tacocloud.beans;


import org.springframework.security.core.userdetails.UserDetails;
import com.example.tacocloud.model.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.tacocloud.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @Configuration
// public class SecurityConfig {
    
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return  new BCryptPasswordEncoder();
//     }

//     // @Bean
//     // public UserDetailsService userDetailsService(PasswordEncoder encoder){
//     //     List<UserDetails> users  = new   ArrayList<>();
        
//     //     users.add(
            
//     //         new User(
//     //             "Buzz",
//     //             encoder.encode("Password"),
//     //             Arrays.asList(new  SimpleGrantedAuthority("ROLE_USER"))
//     //         )
            
//     //     );
//     //     users.add(
            
//     //         new User(
//     //             "Woody",
//     //             encoder.encode("Password"),
//     //             Arrays.asList(new  SimpleGrantedAuthority("ROLE_USER"))
//     //         )
            
//     //     );

//     //     return new InMemoryUserDetailsManager(users);
        
//     // }

//     @Bean UserDetailsService userDetailsService(UserRepository userRepo){
//         return username -> {
//             com.example.tacocloud.model.User user = userRepo.findByUsername(username);
//             if( user != null) return user;

//             throw new  UsernameNotFoundException("User ' " +  username + " ' not found.");
//         };
//     }
// }

