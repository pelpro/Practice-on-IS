package ru.sbt.darkspy.weatherObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherCurrently {
    public Double temperature;
}
