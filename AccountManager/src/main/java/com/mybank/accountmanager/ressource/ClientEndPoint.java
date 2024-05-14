package com.mybank.accountmanager.ressource;


import com.mybank.persistencemanager.entities.Client;
import com.mybank.persistencemanager.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/clients")
public class ClientEndPoint {

    @Autowired
    ClientRepository repository;

    @GetMapping
    public Collection<Client> getClients() {
        return repository.findAll();
    }
}
