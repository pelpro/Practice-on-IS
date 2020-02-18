package ru.sbt.darkspy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.darkspy.DarkSpyService;

import java.io.IOException;

@RestController
public class DSController {

    @Autowired
    private DarkSpyService service = new DarkSpyService();

    @RequestMapping("/darkspy")
    public String weather() throws IOException {
        return "The current temperature is " + service.getCurrentWeather().temperature;
    }

}
