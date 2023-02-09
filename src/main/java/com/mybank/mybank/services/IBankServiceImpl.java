package com.mybank.mybank.services;

import com.mybank.mybank.entities.*;
import com.mybank.mybank.repositories.AccountRepository;
import com.mybank.mybank.repositories.ClientRepository;
import com.mybank.mybank.repositories.OperationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional // make sure it is imported from spring framework package
public class IBankServiceImpl implements IBankService{

    @Autowired
    AccountRepository accountRepository ;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OperationRespository operationRespository;


    @Override
    public Compte consulterUnCompte(String codeCompte) {
        return Optional.ofNullable(accountRepository.findByCodeDeCompte(codeCompte))
                .orElseThrow(() -> new RuntimeException("Account not found for code : " + codeCompte));
    }

    @Override
    public void verser(String codeCompte, double montant) {
        Compte compte= accountRepository.findByCodeDeCompte(codeCompte);
        Versement versement = new Versement();
        versement.setMontant(montant);
        operationRespository.save(versement);
        compte.setSolde(compte.getSolde()+montant);
        accountRepository.save(compte);

    }

    @Override
    public void retirer(String codeCompte, double montant) {
        Compte compte= accountRepository.findByCodeDeCompte(codeCompte);
        if (compte.getSolde()+getFacilities(compte)<montant) throw new RuntimeException("Solde insuffisant pour réaliser cet operation");
        Retrait retrait = new Retrait();
        retrait.setMontant(montant);
        operationRespository.save(retrait);
        compte.setSolde(compte.getSolde()-montant);
        compte.addOperation(retrait);
        accountRepository.save(compte);
    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, double montant) {
        retirer(codeCompte1,montant);
        verser(codeCompte2,montant);
    }

    @Override
    public Page<Operation> listOfOperations(String codeCompte, int page, int size) {
        return operationRespository.getListOperations(codeCompte,PageRequest.of(page,size));
    }


    private double getFacilities(Compte compte){
        double facilities = 0;
        if (compte instanceof CompteCourant courant) facilities = courant.getDecouvert();
        return facilities;
    }
}
