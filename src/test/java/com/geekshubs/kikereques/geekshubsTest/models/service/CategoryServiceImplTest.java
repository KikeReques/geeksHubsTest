package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Category;
import com.geekshubs.kikereques.geekshubsTest.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;

    @MockBean
    CategoryRepository categoryRepository;


    @Test
    void byId() {
        Category category = new Category();
        category.setId(5L);
        category.setName("Hogar");
        category.setDescription("Sección de productos del hogar");

        when(categoryRepository.findById(5L)).thenReturn(java.util.Optional.of(category));

        Assert.assertNotNull(categoryRepository.findById(5L));

        Assert.assertEquals(categoryRepository.findById(5L), java.util.Optional.of(category));
    }

}