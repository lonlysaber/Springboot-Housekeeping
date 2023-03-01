package com.zjz.housekeeping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HousekeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousekeepingApplication.class, args);
    }

}
