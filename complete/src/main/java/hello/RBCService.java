package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.sun.tools.javac.util.Pair;
import hello.DAO.Entity.RateTable;
import hello.DAO.Repositories.RateCrudRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
public class RBCService{

    public static void main(String[] args) {
        SpringApplication.run(RBCService.class, args);
    }
    //public double getMaxRateForLastMonth() {
    //    return getMaxFromArray(parseResponse(getResponse()));
    //}

    public Double getMaxFromArray(List<Double> doubleList) {
        double max = Double.MIN_VALUE;
        for (Double d : doubleList) {
            max = Math.max(max, d);
        }
        return max;
    }

    public String getResponse() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://export.rbc.ru/free/selt.0/free.fcgi?period=DAILY&tickers=USD000000TOD&separator=,&data_format=BROWSER&lastdays=30";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        return response.getBody();
    }

    public ArrayList<Pair<Double,Date>> parseResponse(String responseString) {
        String[] lines = responseString.split("\n");
        ArrayList<Pair<Double, Date>> ans = new ArrayList<>();

        for (String line : lines) {
            String[] elements = line.split(",");
            Pair<Double,Date> pair = new Pair(Double.parseDouble(elements[elements.length - 1]),elements[1]);
            ans.add(pair);
        }
        return ans;
    }
    @Resource
    public RateCrudRepository rateCrudRepository;
    public void writeToDB() throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("2019-10-10");
        ArrayList<Pair<Double,Date>> ansList = parseResponse(getResponse());
        for (Pair pair : ansList){
            Double rate = (Double) pair.fst;
            RateTable rateTable = new RateTable(rate,simpleDateFormat.parse((String) pair.snd));
            rateCrudRepository.save(rateTable);
        }
    }
}
