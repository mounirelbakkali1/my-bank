package com.mybank.accountmanager.services;

import com.mybank.persistencemanager.entities.Compte;
import com.mybank.persistencemanager.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface IGestionCompteService {
    public Compte consulterUnCompte(String codeCompte);

    public void verser(String codeCompte, BigDecimal montant);

    public void retirer(String codeCompte, BigDecimal montant);

    public void virement(String codeCompte1, String codeCompte2, BigDecimal montant);

    public Page<Operation> listOfOperations(String codeCompte, int page, int size);

}
