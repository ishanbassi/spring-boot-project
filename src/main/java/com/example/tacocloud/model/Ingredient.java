package com.example.tacocloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access =AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Ingredient {
    
    @Id private String  id;

    private final String name;
    private final Type type;

    public enum Type{
        WRAP , PROTEIN , VEGGIES, CHEESE , SAUCE
    }

    

}
