package com.example.tacocloud.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tacocloud.model.Taco;
import com.example.tacocloud.repository.TacoRepository;


@RestController
@RequestMapping(path="/api/tacos", produces ="application/json")
@CrossOrigin(origins="http://localhost:4200")
public class TacoRestController {
    private TacoRepository tacoRepository;
    
    TacoRestController(TacoRepository tacoRepo) {
        this.tacoRepository = tacoRepo;
    }

    @GetMapping(params="recent")
    public Iterable<Taco> recentTaco() {
        return this.tacoRepository.
    }

}
