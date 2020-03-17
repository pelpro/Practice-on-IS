package ru.sbt.rbc;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Entity
@Table(name="rate")
public class Rate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Double rate;
    private String date;

    public Rate() {}

    public String dateFormat(Date date) {
        final DateFormat dateFormat = new SimpleDateFormat("EEE MM dd kk:mm:ss zzzz yyyy", Locale.ENGLISH);
        return dateFormat.format(date);
    }

    public Rate(Double rate, Date date) {
        this.rate = rate;
        this.date = dateFormat(date);
    }

    public Double getRate() {
        return rate;
    }
}