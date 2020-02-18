package ru.sbt.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PredictionService {

    public static void main(String[] args) {
        SpringApplication.run(PredictionService.class, args);
    }
    public String predict() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://127.0.0.1:8083/rates{20}";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String rates = response.getBody();
        String url2 = "http://127.0.0.1:8081/darkspy";
        ResponseEntity<String> response2 = restTemplate.getForEntity(url, String.class);
        String weather = response2.getBody();
        return rates+weather;
    }
}