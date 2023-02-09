package com.mybank.mybank.services;

import com.mybank.mybank.entities.Compte;
import jakarta.annotation.security.RunAs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class IBankServiceImplTest {

    @Autowired IBankServiceImpl service;

    @Test
    void consulterUnCompte() {
        Compte compte = service.consulterUnCompte("MA89UY89");
        assertNotNull(compte);
    }
}