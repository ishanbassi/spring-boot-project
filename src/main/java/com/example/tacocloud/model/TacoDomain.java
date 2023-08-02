package com.example.tacocloud.model;

import java.util.List;

import lombok.Data;

@Data
public class TacoDomain {
    private String name;
    private List<IngredientDomain> ingredients;
}
