package ru.sbt.rbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class RBCService{

    public static void main(String[] args) {
        SpringApplication.run(RBCService.class, args);
    }
    public double getMaxRateForLastMonth() throws ParseException {
        return getRates().get(0);
    }

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

    public ArrayList<Pair<Double,Date>> parseResponse(String responseString) throws ParseException {
        String[] lines = responseString.split("\n");
        ArrayList<Pair<Double, Date>> ans = new ArrayList<>();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("2019-10-10");
        for (String line : lines) {
            String[] elements = line.split(",");
            Pair<Double,Date> pair = Pair.of(Double.parseDouble(elements[elements.length - 1]),simpleDateFormat.parse((String)elements[1]));
            ans.add(pair);
        }
        return ans;
    }
    @Resource
    public RateCrudRepository rateCrudRepository;
    public void writeToDB() throws ParseException {
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MM dd kk:mm:ss zzzz yyyy", Locale.ENGLISH);
        Date date = simpleDateFormat.parse("Mon 02 10 24:00:00 Coordinated Universal Time 2020");
        ArrayList<Pair<Double,Date>> ansList = parseResponse(getResponse());
        for (Pair pair : ansList){
            Rate rateTable = new Rate((Double) pair.getFirst(),(Date) pair.getSecond());
            //rateCrudRepository.save(rateTable);
        }
        rateCrudRepository.save(new Rate(1.,date));
    }
    public List<Double> getRates() throws ParseException {
        String responseString = getResponse();
        writeToDB();
        String[] lines = responseString.split("\n");
        ArrayList<Double> ans = new ArrayList<>();
        for (String line : lines) {
            String[] elements = line.split(",");
            Double pair = Double.parseDouble(elements[elements.length - 1]);
            ans.add(pair);
        }
        return ans;
    }
}
