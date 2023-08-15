package com.example.tacocloud.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.repository.IngredientRepository;

@RestController
@RequestMapping(path = "/api/ingredient" , produces = "application/json")
@CrossOrigin(origins = "http:localhost:4200")

public class IngredientRestController {
        private IngredientRepository repo;

        IngredientRestController(IngredientRepository repo) {
            this.repo = repo;
        }

        @GetMapping
        public Iterable<Ingredient> allIngredients() {
            return this.repo.findAll();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        @PreAuthorize("{hasRole('USER')}")
        public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
            return this.repo.save(ingredient);
        }

        @DeleteMapping(path = "/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @PreAuthorize("{hasRole('ADMIN')}")
        public void deleteIngredient(@PathVariable("id") String id){
            this.repo.deleteById(id);;
        }
}
