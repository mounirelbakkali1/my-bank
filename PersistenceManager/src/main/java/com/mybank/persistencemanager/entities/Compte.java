package com.mybank.persistencemanager.entities;


//import com.mybank.mybank.services.CompteListner;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.DiscriminatorType.STRING;
import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "comptes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE", discriminatorType = STRING, length = 2)
//@EntityListeners(CompteListner.class)
@Getter
@Setter
@ToString
public abstract class Compte {

    @Id
    @Column(name = "code_compte")
    private String codeDeCompte;
    @Column(name = "creation_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TIMESTAMP)
    Date CreationDate;
    @Column(name = "solde", columnDefinition = "numeric")
    private BigDecimal solde;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "code_client")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    Collection<Operation> operations = new ArrayList<>();


    @ManyToOne
    Client client;


    public void addOperation(Operation operation) {
        operations.add(operation);
    }

}
