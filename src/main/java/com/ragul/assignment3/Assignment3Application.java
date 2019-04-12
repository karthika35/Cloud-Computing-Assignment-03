package com.ragul.assignment3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ragul.assignment3.model.State;
import com.ragul.assignment3.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@SpringBootApplication
public class Assignment3Application {
    @Autowired
    StateService stateService;

    public static void main(String[] args) {
        SpringApplication.run(Assignment3Application.class, args);
    }

    @Bean
    CommandLineRunner runner(StateService stateService) {
        return args -> {
            // read JSON and load json
            try {
                URL url = new URL("https://gist.githubusercontent.com/mshafrir/2646763/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_titlecase.json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("charset", "utf-8");
                connection.connect();
                InputStream inputStream = connection.getInputStream();

                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<State>> typeReference = new TypeReference<List<State>>() {
                };

                List<State> states = mapper.readValue(inputStream, typeReference);
                stateService.save(states);
                System.out.println("states Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save states: " + e.getMessage());
            }
        };
    }


}
