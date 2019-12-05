package hello.Representation.weatherObjects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    public WeatherDaily daily;
    public WeatherCurrently currently;
}