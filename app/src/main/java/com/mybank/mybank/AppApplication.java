package com.mybank.mybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.mybank"} )
@EnableJpaRepositories("com.mybank.persistencemanager")
@EntityScan("com.mybank.persistencemanager")
public class AppApplication {

    // for configurations

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
