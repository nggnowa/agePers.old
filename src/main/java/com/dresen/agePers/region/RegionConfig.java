package com.dresen.agePers.region;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RegionConfig {

    @Bean
    public CommandLineRunner commandLineRunnerRegion(RegionRepository repository) {

        return args -> {

            Region ad = new Region(
                    null,
                    "Adamaoua",
                    "AD",
                    null
            );

            Region ce = new Region(
                    null,
                    "Centre",
                    "CE",
                    null
            );
            Region en = new Region(
                    null,
                    "Extrême-Nord",
                    "EN",
                    null
            );
            Region es = new Region(
                    null,
                    "Est",
                    "ES",
                    null
            );
            Region lt = new Region(
                    null,
                    "Littoral",
                    "LT",
                    null
            );

            Region no = new Region(
                    null,
                    "Nord",
                    "NO",
                    null
            );
            Region nw = new Region(
                    null,
                    "Nord-Ouest",
                    "NW",
                    null
            );
            Region ou = new Region(
                    null,
                    "Ouest",
                    "OU",
                    null
            );
            Region su = new Region(
                    null,
                    "Sud",
                    "SU",
                    null
            );
            Region sw = new Region(
                    null,
                    "Sud-Ouest",
                    "SW",
                    null
            );

            repository.saveAll(List.of(ad, ce, en, es, lt, no, nw, ou, su, sw));

        };
    }

}
