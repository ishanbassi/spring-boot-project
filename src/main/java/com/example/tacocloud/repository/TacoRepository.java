package com.example.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
import com.example.tacocloud.model.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco,Long> , CrudRepository<Taco,Long> {
    
}
