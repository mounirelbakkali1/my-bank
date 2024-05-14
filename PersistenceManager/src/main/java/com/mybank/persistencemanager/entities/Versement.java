package com.mybank.persistencemanager.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {
}
