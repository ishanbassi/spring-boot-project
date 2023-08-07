package com.example.tacocloud.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.tacocloud.model.Ingredient;


@Configuration
public class initDatabase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<Ingredient> findIngredientById(String id) {
        List<Ingredient> results =  jdbcTemplate.query(
            "select id, name, type from Ingredient where id=?",
            this::mapRowToIngredient,
  
         null);
            return results.size() == 0  ? 
                Optional.empty() : Optional.of(results.get(0))
    }

    public void mapRowToIngredient() {

    }

    
}
