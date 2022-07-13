package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Category;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

    List<Category> list();
    Optional<Category> byId(Long id);
    Category save(Category category);
    void delete(Long id);


}
