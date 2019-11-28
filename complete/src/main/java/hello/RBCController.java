package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
public class RBCController {
    @Autowired
    private RBCService service = new RBCService();

    @RequestMapping("/")
    public @ResponseBody
    double getMaxRate() throws ParseException {
        service.writeToDB();
        return 0;
    }
}