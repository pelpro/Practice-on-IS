package ru.sbt.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PredictionService {

    public static void main(String[] args) {
        SpringApplication.run(PredictionService.class, args);
    }

    public String predict() throws IOException, RestClientException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://10.5.0.7:8083/rates";
        HttpEntity<Integer> request = new HttpEntity<>(5);
        ResponseEntity<String> response = restTemplate.postForEntity(url,request,String.class);
        String rates = response.getBody();
        System.out.println(rates);
        String url2 = "http://10.5.0.6:8081/darkspy";
        ResponseEntity<String> response2 = restTemplate.getForEntity(url2, String.class);
        String weather = response2.getBody();
        return rates+weather;
    }
}