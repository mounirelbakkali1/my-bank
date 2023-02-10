package com.mybank.mybank.services;

import com.mybank.mybank.entities.Compte;
import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CompteListner {
    @PrePersist
    void prePersist(Compte compte){
        compte.setCreationDate(new Timestamp(System.currentTimeMillis()));
    }
}
