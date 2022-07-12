package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Client;

import java.util.List;
import java.util.Optional;


public interface ClientService {

    List<Client> list();
    Optional<Client> byId(Long id);
    Client save(Client client);
    void delete(Long id);


}
