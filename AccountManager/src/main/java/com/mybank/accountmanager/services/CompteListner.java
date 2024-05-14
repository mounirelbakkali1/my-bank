package com.mybank.accountmanager.services;

import com.mybank.persistencemanager.entities.Compte;
import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CompteListner {
    @PrePersist
    void prePersist(Compte compte) {
        compte.setCreationDate(new Timestamp(System.currentTimeMillis()));
    }
}
