package com.mybank.persistencemanager.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CC")
@Getter
@Setter
public class CompteCourant extends Compte {

    private double decouvert;


}
