package com.mybank.persistencemanager.repositories;

import com.mybank.persistencemanager.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Compte, Long> {
    Compte findByCodeDeCompte(String code_utilisateur);
}
