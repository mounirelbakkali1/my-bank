package com.mybank.mybank.services;

import com.mybank.mybank.entities.Compte;
import com.mybank.mybank.entities.Operation;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public interface IBankService {
    public Compte consulterUnCompte(String codeCompte);
    public void verser(String codeCompte, BigDecimal montant);
    public void retirer(String codeCompte, BigDecimal montant);
    public void virement(String codeCompte1,String codeCompte2,BigDecimal montant);
    public Page<Operation> listOfOperations(String codeCompte , int page , int size);

}
