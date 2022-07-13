package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Order;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    List<Order> list();
    Optional<Order> byId(Long id);
    Order save(Order order);
    void delete(Long id);


}
