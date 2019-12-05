package hello.Controllers;

import hello.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PredictionControllers{

    @Autowired
    private PredictionService service = new PredictionService();

    @RequestMapping("/prediction")
    public Double index() throws IOException {
        return service.predict();
    }

}
