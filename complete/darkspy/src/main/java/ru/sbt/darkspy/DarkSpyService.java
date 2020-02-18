package ru.sbt.darkspy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.sbt.darkspy.weatherObjects.WeatherCurrently;
import ru.sbt.darkspy.weatherObjects.WeatherResponse;
import ru.sbt.darkspy.weatherObjects.WeatherTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DarkSpyService {
    private static final String URL_GET_TEMP = "https://api.darksky.net/forecast/";
    private static final String SECRET = "7680422f32effb534f62f1283f0c38be";

    RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {
        SpringApplication.run(DarkSpyService.class, args);
    }

//    @Resource
//    public RateCrudRepository weatherCrudRepository;

    public String getResponse(String time){
        String url = URL_GET_TEMP+SECRET+"/42.3601,-71.0589," + time;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        return response.getBody();
    }

    public WeatherResponse parseResponse(String responseString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        weatherResponse = objectMapper.readValue(responseString, WeatherResponse.class);
        return weatherResponse;
    }

    public WeatherCurrently getCurrentWeather() throws IOException {
        long unixTime = System.currentTimeMillis() / 1000L;
        String responseBody = getResponse("" + unixTime);
        WeatherResponse response = parseResponse(responseBody);
        return response.currently;
    }

    public WeatherTable getDailyWeather(String responseBody) throws IOException {
        WeatherResponse response = parseResponse(responseBody);
        return response.daily.data.get(0);
    }


    public List<Double> getWeather() throws IOException {
        List<Double> data = new ArrayList<>();
        long unixTime = System.currentTimeMillis() / 1000L;
        for (long i = 0; i < 20; i++) {
            WeatherTable weatherRecord = getDailyWeather(getResponse("" + (unixTime - i * 86400L)));
            data.add(weatherRecord.highTemp);
        }
        return data;
    }

}

