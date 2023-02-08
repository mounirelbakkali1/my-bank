package com.mybank.mybank.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.DiscriminatorType.STRING;
import static jakarta.persistence.InheritanceType.SINGLE_TABLE;
import static jakarta.persistence.TemporalType.DATE;

@Entity
@Table(name = "operations")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPRATION",discriminatorType = STRING,length = 1)
@Setter
@Getter
public abstract class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "numero_operation")
    private long numOfOperation ;

    @Temporal(DATE)
    private Date dateOfOperation ;

    private double montant;



}