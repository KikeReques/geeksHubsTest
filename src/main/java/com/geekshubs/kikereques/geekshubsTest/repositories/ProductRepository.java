package com.geekshubs.kikereques.geekshubsTest.repositories;


import com.geekshubs.kikereques.geekshubsTest.models.entity.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {

}
