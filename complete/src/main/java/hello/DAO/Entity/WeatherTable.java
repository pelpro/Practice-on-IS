package hello.DAO.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="Weather_Table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherTable {

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Double temperature;
    private String date;


    public WeatherTable() {}

    public static String dateFormat(Date date) {
        return dateFormat.format(date);
    }

    public WeatherTable(Double temperature, Date date) {
        this.temperature = temperature;
        this.date = dateFormat.format(date);
    }

    public Double getTemperature() {
        return temperature;
    }
}