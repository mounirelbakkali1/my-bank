package com.mybank.persistencemanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long code;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name = "client_id")
    @Fetch(SUBSELECT)
    private Collection<Compte> comptes = new ArrayList<>();


    public void addAccount(Compte compte) {
        comptes.add(compte);
    }

}
