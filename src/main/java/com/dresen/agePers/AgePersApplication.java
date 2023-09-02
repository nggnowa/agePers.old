package com.dresen.agePers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AgePersApplication {


    public static void main(String[] args) {

        SpringApplication.run(AgePersApplication.class, args);

    }

}
