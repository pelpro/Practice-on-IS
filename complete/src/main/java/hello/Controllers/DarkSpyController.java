package hello.Controllers;

import hello.DarkSpyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DarkSpyController {

    @Autowired
    private DarkSpyService service = new DarkSpyService();

    @RequestMapping("/darkspy")
    public String weather() throws IOException {
        return "The current temperature is " + service.getCurrentWeather().temperature;
    }

}
