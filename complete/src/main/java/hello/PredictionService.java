package hello;

import hello.Representation.weatherObjects.WeatherCurrently;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class PredictionService {

    @Autowired
    private RBCService rbcService;
    @Autowired
    private DarkSpyService weatherService;

    public Double predict() throws IOException {
        List<Double> rates = rbcService.getRates();
        Collections.reverse(rates);
        List<Double> weather = weatherService.getWeather();
        String out = "";
        List<Double> x = rates.subList(0, weather.size());
        Double sumX = 0.0;
        Double sumX2 = 0.0;
        for (Double xi: x) {
            sumX += xi;
            sumX2 += xi * xi;
        }
        Double sumY = 0.0;
        for (Double yi: rates) {
            sumY += yi;
        }

        assert(x.size() == rates.size());

        Double sumXY = 0.0;
        for (int i = 0; i < rates.size(); i++) {
            sumXY += x.get(i) * rates.get(i);
        }
        Integer n = x.size();
        Double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        Double a = (sumY - b * sumX) / x.size();
        WeatherCurrently weatherCurrent = weatherService.getCurrentWeather();
        Double temperature = weatherCurrent.temperature;
        return a + b * temperature;
    }
}