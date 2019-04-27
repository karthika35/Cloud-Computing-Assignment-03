package com.ragul.assignment3;

import com.ragul.assignment3.service.DataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Assignment3Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment3Application.class, args);
    }

    @Bean
    CommandLineRunner runner(DataService dataService) {
        return args -> dataService.getDataFromFile();
    }


}
