package com.example.tacocloud.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
@Entity
@RestResource(path="tacos" , rel ="tacos")
public class Taco {

    @Size(min =5, message ="Name must be at least 5 characters long")        
    @NotNull
    private String name;

    @Size(min=1, message = "You must choose  at least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    
    private Date createdAt   = new Date() ;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
