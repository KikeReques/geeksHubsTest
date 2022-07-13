package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Product;
import com.geekshubs.kikereques.geekshubsTest.models.entity.ProductPurchase;
import com.geekshubs.kikereques.geekshubsTest.repositories.ProductPurchaseRepository;
import com.geekshubs.kikereques.geekshubsTest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPurchaseServiceImpl implements ProductPurchaseService{

    @Autowired
    ProductPurchaseRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<ProductPurchase> list() {
        return (List<ProductPurchase>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductPurchase> byId(Long id) {
        return repository.findById(id);
    }

    @Override
    public ProductPurchase save(ProductPurchase productPurchase) {
        return repository.save(productPurchase);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
