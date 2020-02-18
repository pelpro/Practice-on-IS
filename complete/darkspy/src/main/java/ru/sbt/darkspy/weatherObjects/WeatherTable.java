package ru.sbt.darkspy.weatherObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherTable {
    public double highTemp;
    public int time;
}
