package com.geekshubs.kikereques.geekshubsTest.controllers;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Category;
import com.geekshubs.kikereques.geekshubsTest.models.entity.Product;
import com.geekshubs.kikereques.geekshubsTest.models.service.CategoryService;
import com.geekshubs.kikereques.geekshubsTest.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> list(){

        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        Optional<Product> o = service.byId(id);

        if(o.isPresent()){
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/product")
    public ResponseEntity<?> save(@Valid @RequestBody Product product, BindingResult result){
        if(result.hasErrors()){
            return validate(result);
        }
        Category categoryDb = categoryService.byId(product.getCategory().getId()).get();
        product.setCategory(categoryDb);
        Product productDb = service.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productDb);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Product product, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validate(result);
        }
        Optional<Product> o = service.byId(id);

        if(o.isPresent()){
            Product productDb = o.get();
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            productDb.setAmount(product.getAmount());
            productDb.setCategory(product.getCategory());
            Category categoryDb = categoryService.byId(product.getCategory().getId()).get();
            productDb.setCategory(categoryDb);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> o = service.byId(id);

        if(o.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validate(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}
