package ru.sbt.darkspy.DAO.Entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="Weather_Table")
public class Weather {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Double highTemperature;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHighTemperature(Double temperature) {
        this.highTemperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Weather() {}

    public String dateFormat(Date date) {
        return dateFormat.format(date);
    }

    public Weather(Double temperature, Date date) {
        this.highTemperature = temperature;
        this.date = dateFormat.format(date);
    }

    public Double getTemperature() {
        return highTemperature;
    }
}