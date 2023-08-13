package com.example.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tacocloud.model.TacoOrder;
import java.util.List;


public interface OrderRepository extends CrudRepository<TacoOrder,Long> {
     List<TacoOrder> findByDeliveryZip(String deliveryZip);
     
}
