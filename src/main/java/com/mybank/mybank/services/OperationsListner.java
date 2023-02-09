package com.mybank.mybank.services;


import com.mybank.mybank.entities.Operation;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OperationsListner {

    @Autowired INumOperation numOperation;

    @PrePersist void prePersist(Operation operation){
        operation.setNumOfOperation(numOperation.generateNumOperation());
        operation.setDateOfOperation(new Date());
    }
}
