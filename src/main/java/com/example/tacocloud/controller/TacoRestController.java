package com.example.tacocloud.controller;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repository.OrderRepository;
import com.example.tacocloud.repository.TacoRepository;


@RestController
@RequestMapping(path="/api/tacos", produces ="application/json")
@CrossOrigin(origins="*")
public class TacoRestController {
    private TacoRepository tacoRepository;
    private OrderRepository orderRepo;
    
    TacoRestController(TacoRepository tacoRepo , OrderRepository orderRepo) {
        this.tacoRepository = tacoRepo; 
        this.orderRepo =  orderRepo;
    }
    
    @GetMapping(params="recent")
    public Iterable<Taco> recentTaco() {
            PageRequest pageRequest = PageRequest.of(
                0, 12, Sort.by("createdAt").descending()
            );
            return tacoRepository.findAll(pageRequest).getContent();
            
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        
        Optional<Taco> taco =  tacoRepository.findById(id);
        if(taco.isPresent()) return new ResponseEntity<>(taco.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    
    @PostMapping(consumes="application/json")
    
    public ResponseEntity<Taco> saveTaco(@RequestBody Taco taco) {
        return new ResponseEntity<Taco>(tacoRepository.save(taco), HttpStatus.CREATED) ;
    }

    



}
