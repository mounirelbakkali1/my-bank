package com.mybank.mybank.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.DiscriminatorType.STRING;
import static jakarta.persistence.TemporalType.DATE;

@Entity
@Table(name = "comptes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE",discriminatorType = STRING,length = 2)
@Getter
@Setter
@ToString
public abstract class Compte {

    @Id
            @Column(name = "code_compte")
    private String codeDeCompte;
    @Column(name = "creation_date")
            @Temporal(DATE)
    Date CreationDate;
    @Column(name = "solde",columnDefinition = "BIGINT")
    private double solde;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "code_client")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    Collection<Operation> operations= new ArrayList<>();


    @ManyToOne
    Client client;


    public void addOperation(Operation operation){
        operations.add(operation);
        if (operation instanceof Retrait retrait){
            solde-= retrait.getMontant();
        } else if (operation instanceof Versement versement) {
            solde+= versement.getMontant();
        }
    }

}
