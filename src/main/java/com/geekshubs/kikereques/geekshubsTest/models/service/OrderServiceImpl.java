package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Category;
import com.geekshubs.kikereques.geekshubsTest.models.entity.Order;
import com.geekshubs.kikereques.geekshubsTest.repositories.CategoryRepository;
import com.geekshubs.kikereques.geekshubsTest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Order> list() {
        return (List<Order>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> byId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
