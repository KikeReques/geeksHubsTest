package com.geekshubs.kikereques.geekshubsTest.repositories;


import com.geekshubs.kikereques.geekshubsTest.models.entity.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, Long> {


}
