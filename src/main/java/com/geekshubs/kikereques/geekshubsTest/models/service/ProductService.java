package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> list();
    Optional<Product> byId(Long id);
    Product save(Product curso);
    void delete(Long id);


}
