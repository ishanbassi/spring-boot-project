package com.example.tacocloud.controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.Response;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repository.OrderRepository;

@RestController
@RequestMapping(produces ="application/json", path = "api/order")

public class OrderRestController {
    private OrderRepository repo;
    
    OrderRestController(OrderRepository orderRepo){
        this.repo = orderRepo;
    }

    @GetMapping(consumes = "application/json")
    public Iterable<TacoOrder> getOrders() {
        return this.repo.findAll();
    }

    

    @GetMapping(path="/{id}")
    public ResponseEntity<TacoOrder> getOrder(@PathVariable("id") Long id) {
        Optional<TacoOrder> order =  this.repo.findById(id);
        if(order.isPresent()) return new ResponseEntity<TacoOrder>(order.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @PostMapping(consumes="application/json")
    public ResponseEntity<TacoOrder> saveOrder(@RequestBody TacoOrder order) {
        return new ResponseEntity<TacoOrder>(repo.save(order) ,  HttpStatus.CREATED) ;
    }
    @PutMapping(consumes="application/json", path="/{id}" )
    
    public TacoOrder putOrder(@PathVariable("id") Long id , @RequestBody TacoOrder order) {
        order.setId(id);
        System.out.println(id);
        return repo.save(order);
    }


    @PatchMapping(consumes ="application/json", path ="/{id}")
    public TacoOrder patchOrder(@PathVariable("id") Long id ,  @RequestBody TacoOrder  patch) {
        TacoOrder order =  this.repo.findById(id).get();
        System.out.println(patch);

        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
            }
            if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
            }
            if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
            }
            if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
            }
            if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
            }
            if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
            }
            if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
            }
            if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
            }

        return this.repo.save(order);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long id ) {
        try{
            this.repo.deleteById(id);
        }
        catch(DataAccessException e ){
            
        }
    }
    
}
