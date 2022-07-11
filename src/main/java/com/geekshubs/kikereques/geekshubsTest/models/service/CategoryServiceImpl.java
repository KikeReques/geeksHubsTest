package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Category;
import com.geekshubs.kikereques.geekshubsTest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Category> list() {
        return (List<Category>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Category> byId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category save(Category curso) {
        return repository.save(curso);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
