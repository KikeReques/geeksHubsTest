package com.geekshubs.kikereques.geekshubsTest.controllers;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Category;
import com.geekshubs.kikereques.geekshubsTest.models.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> listar(){

        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Category> o = service.byId(id);

        if(o.isPresent()){
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/category")
    public ResponseEntity<?> guardar(@Valid @RequestBody Category category, BindingResult result){

        if(result.hasErrors()){
            return validate(result);
        }
        Category categoryDb = service.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDb);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Category category, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validate(result);
        }
        Optional<Category> o = service.byId(id);

        if(o.isPresent()){
            Category categoryDb = o.get();
            categoryDb.setName(category.getName());
            categoryDb.setDescription(category.getDescription());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoryDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Category> o = service.byId(id);

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
