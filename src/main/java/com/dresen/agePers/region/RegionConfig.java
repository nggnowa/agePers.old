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
                    "AD"
            );

            Region ce = new Region(
                    null,
                    "Centre",
                    "CE"
            );
            Region en = new Region(
                    null,
                    "Extrême-Nord",
                    "EN"
            );
            Region es = new Region(
                    null,
                    "Est",
                    "ES"
            );
            Region lt = new Region(
                    null,
                    "Littoral",
                    "LT"
            );

            Region no = new Region(
                    null,
                    "Nord",
                    "NO"
            );
            Region nw = new Region(
                    null,
                    "Nord-Ouest",
                    "NW"
            );
            Region ou = new Region(
                    null,
                    "Ouest",
                    "OU"
            );
            Region su = new Region(
                    null,
                    "Sud",
                    "SU"
            );
            Region sw = new Region(
                    null,
                    "Sud-Ouest",
                    "SW"
            );

            repository.saveAll(List.of(ad, ce, en, es, lt, no, nw, ou, su, sw));

        };
    }

}
