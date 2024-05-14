package com.mybank.accountmanager.services;

import com.mybank.persistencemanager.entities.*;
import com.mybank.persistencemanager.repositories.AccountRepository;
import com.mybank.persistencemanager.repositories.ClientRepository;
import com.mybank.persistencemanager.repositories.OperationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;


@Service
@Transactional // make sure it is imported from spring framework package
public class IGestionCompteServiceImpl implements IGestionCompteService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OperationRespository operationRespository;


    @Override
    public Compte consulterUnCompte(String codeCompte) {
        return Optional.ofNullable(accountRepository.findByCodeDeCompte(codeCompte))
                .orElseThrow(() -> new RuntimeException("il y a pas un compte associe a ce code : " + codeCompte));
    }

    @Override
    public void verser(String codeCompte, BigDecimal montant) {
        Compte compte = consulterUnCompte(codeCompte);
        Versement versement = new Versement();
        versement.setMontant(montant);
        operationRespository.save(versement);
        compte.setSolde(compte.getSolde().add(montant));
        compte.addOperation(versement);
        accountRepository.save(compte);

    }

    @Override
    public void retirer(String codeCompte, BigDecimal montant) {
        Compte compte = consulterUnCompte(codeCompte);
        if (compte.getSolde().add(BigDecimal.valueOf(getFacilities(compte))).compareTo(montant) == -1)
            throw new RuntimeException("Solde insuffisant pour realiser cet operation");
        Retrait retrait = new Retrait();
        retrait.setMontant(montant);
        operationRespository.save(retrait);
        compte.setSolde(compte.getSolde().subtract(montant));
        compte.addOperation(retrait);
        accountRepository.save(compte);
    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, BigDecimal montant) {
        retirer(codeCompte1, montant);
        verser(codeCompte2, montant);
    }

    @Override
    public Page<Operation> listOfOperations(String codeCompte, int page, int size) {
        return operationRespository.getListOperations(codeCompte, PageRequest.of(page, size));
    }


    private double getFacilities(Compte compte) {
        double facilities = 0;
        if (compte instanceof CompteCourant courant) facilities = courant.getDecouvert();
        return facilities;
    }
}
