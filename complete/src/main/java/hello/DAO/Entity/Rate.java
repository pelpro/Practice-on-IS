package hello.DAO.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="Rate_Table")
public class Rate {

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Double rate;
    private String date;

    public Rate() {}

    public static String dateFormat(Date date) {
        return dateFormat.format(date);
    }

    public Rate(Double rate, Date date) {
        this.rate = rate;
        this.date = dateFormat.format(date);
    }

    public Double getRate() {
        return rate;
    }
}