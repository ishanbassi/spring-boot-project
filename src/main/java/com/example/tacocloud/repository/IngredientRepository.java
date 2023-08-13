package com.example.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.tacocloud.model.Ingredient;



public interface IngredientRepository extends CrudRepository<Ingredient,String> {
    
}
