package hello;

import hello.DAO.Repositories.RateCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class DarkSpyService {
    private static final String URL_GET_TEMP = "https://api.darksky.net/forecast/";
    private static final String SECRET = "7680422f32effb534f62f1283f0c38be";

    @Resource
    public RateCrudRepository WeatherCrudRepository;

    @CrossOrigin
    @GetMapping
    public String getLastDaysTemp() {
        String url = URL_GET_TEMP+SECRET+"/42.3601,-71.0589,255657600?exclude=currently,flag";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
//      WeatherTable response = Optional.ofNullable(restTemplate.getForObject(url, WeatherTable.class))
//                    .orElseThrow(() -> new RuntimeException("Data not found"));
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

        System.out.println(response.getBody());

        return url;
    }
}
