package com.mybank.mybank;

import com.mybank.mybank.entities.*;
import com.mybank.mybank.repositories.AccountRepository;
import com.mybank.mybank.repositories.ClientRepository;
import com.mybank.mybank.services.IBankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class MyBankApplication {

    @Autowired
    IBankServiceImpl iBankService;

    @Autowired AccountRepository accountRepository;
    @Autowired ClientRepository clientRepository;


    public static void main(String[] args) {
        SpringApplication.run(MyBankApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
         /*   iBankService.verser("MA89UY90",1900);
            iBankService.retirer("MA89UY90",900);
            iBankService.verser("MA89UY90",8000);*/
       /*     CompteEpargne compteEpargne = new CompteEpargne();
            compteEpargne.setCodeDeCompte("MA89UY92");
            compteEpargne.setSolde(3000);
            compteEpargne.setTaux(2.3);

            Optional<Client> client = clientRepository.findById(1L);
            client.ifPresent(client1 ->{
                client1.addAccount(compteEpargne);
                clientRepository.save(client1);
            });*/

        };
    }
}
