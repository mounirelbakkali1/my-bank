package com.mybank.accountmanager.services;


import com.mybank.persistencemanager.entities.Operation;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class OperationsListner {

    @Autowired
    INumOperation numOperation;

    @PrePersist
    void prePersist(Operation operation) {
        operation.setNumOfOperation(numOperation.generateNumOperation());
        operation.setDateOfOperation(new Timestamp(System.currentTimeMillis()));
    }
}
