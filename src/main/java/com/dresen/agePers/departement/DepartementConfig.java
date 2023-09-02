package com.dresen.agePers.departement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartementConfig {

    @Bean
    public CommandLineRunner commandLineRunnerDepartement(DepartementRepository repository) {

        return args -> {

            Departement tibati = new Departement(
                    null,
                    "Tibati",
                    null,
                    null
            );

        };
    }

}
