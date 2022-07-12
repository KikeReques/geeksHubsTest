package com.geekshubs.kikereques.geekshubsTest.controllers;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Client;
import com.geekshubs.kikereques.geekshubsTest.models.entity.Order;
import com.geekshubs.kikereques.geekshubsTest.models.entity.Product;
import com.geekshubs.kikereques.geekshubsTest.models.service.ClientService;
import com.geekshubs.kikereques.geekshubsTest.models.service.OrderService;
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
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ClientService clientService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> list(){

        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        Optional<Order> o = service.byId(id);

        if(o.isPresent()){
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/order")
    public ResponseEntity<?> save(@Valid @RequestBody Order order, BindingResult result){
        if(result.hasErrors()){
            return validate(result);
        }
        Client clientDb = clientService.byId(order.getClient().getId()).get();
        order.setClient(clientDb);
        Order orderDb = service.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDb);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Order order, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validate(result);
        }
        Optional<Order> o = service.byId(id);

        if(o.isPresent()){
            Order orderDb = o.get();
            orderDb.setOrderDate(order.getOrderDate());
            orderDb.setPayMethod(order.getPayMethod());
            orderDb.setStatus(order.getStatus());
            Client clientDb = clientService.byId(order.getClient().getId()).get();
            order.setClient(clientDb);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(orderDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Order> o = service.byId(id);

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
