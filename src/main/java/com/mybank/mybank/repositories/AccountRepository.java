package com.mybank.mybank.repositories;

import com.mybank.mybank.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Compte,Long> {
    Compte findByCodeDeCompte(String code_utilisateur);
}
