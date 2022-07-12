package com.geekshubs.kikereques.geekshubsTest.controllers;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Category;
import com.geekshubs.kikereques.geekshubsTest.models.entity.Client;
import com.geekshubs.kikereques.geekshubsTest.models.service.CategoryService;
import com.geekshubs.kikereques.geekshubsTest.models.service.ClientService;
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
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/client")
    public ResponseEntity<List<Client>> list(){

        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        Optional<Client> o = service.byId(id);

        if(o.isPresent()){
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/client")
    public ResponseEntity<?> save(@Valid @RequestBody Client client, BindingResult result){

        if(result.hasErrors()){
            return validate(result);
        }
        Client clientDb = service.save(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientDb);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Client client, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validate(result);
        }
        Optional<Client> o = service.byId(id);

        if(o.isPresent()){
            Client clientDb = o.get();
            clientDb.setName(client.getName());
            clientDb.setSurName(client.getSurName());
            clientDb.setTelephoneNumber(client.getTelephoneNumber());
            clientDb.setBirthDate(client.getBirthDate());
            clientDb.setEmail(client.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Client> o = service.byId(id);

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
