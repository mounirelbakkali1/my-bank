package com.mybank.persistencemanager.entities;

//import com.mybank.mybank.services.OperationsListner;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

import static jakarta.persistence.DiscriminatorType.STRING;
import static jakarta.persistence.InheritanceType.SINGLE_TABLE;
import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "operations")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPRATION", discriminatorType = STRING, length = 1)
@Setter
@Getter
@NoArgsConstructor
//@EntityListeners(OperationsListner.class)
public abstract class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "numero_operation")
    private long numOfOperation;


    @Temporal(TIMESTAMP)
    @Column(name = "date_of_operation", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateOfOperation;

    private BigDecimal montant;

    @ManyToOne
    private Compte compte;


}