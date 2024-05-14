package com.mybank.persistencemanager.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CE")
@Getter
@Setter
public class CompteEpargne extends Compte {
    double taux;
}
