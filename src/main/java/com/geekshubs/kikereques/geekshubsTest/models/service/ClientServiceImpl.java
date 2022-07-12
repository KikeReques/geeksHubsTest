package com.geekshubs.kikereques.geekshubsTest.models.service;

import com.geekshubs.kikereques.geekshubsTest.models.entity.Client;
import com.geekshubs.kikereques.geekshubsTest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Client> list() {
        return (List<Client>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> byId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
