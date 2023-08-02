package com.example.tacocloud.model;

import lombok.Data;

@Data
public class IngredientDomain {
    
    private final String id;
    private final String name;
    private final Type type;

    public enum Type{
        WRAP , PROTEIN , VEGGIES, CHEESE , SAUCE
    }

    

}
