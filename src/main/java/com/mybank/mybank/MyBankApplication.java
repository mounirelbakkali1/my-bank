package com.mybank.mybank;

import com.mybank.mybank.entities.Client;
import com.mybank.mybank.entities.CompteEpargne;
import com.mybank.mybank.entities.Retrait;
import com.mybank.mybank.repositories.AccountRepository;
import com.mybank.mybank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class MyBankApplication {

    @Autowired
    ClientRepository clientRepository;


    public static void main(String[] args) {
        SpringApplication.run(MyBankApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Client client = new Client();
            client.setName("mounir");
            client.setCode(8986L);


            CompteEpargne compteEpargne = new CompteEpargne();
            compteEpargne.setCodeDeCompte("MA89UY89");
            compteEpargne.setSolde(9000);
            compteEpargne.setCreationDate(new Date());

            client.addAccount(compteEpargne);

            Retrait retrait = new Retrait();
            retrait.setMontant(2200);
            compteEpargne.addOperation(retrait);

            clientRepository.save(client);
        };
    }
}
