package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DarkSpyController {

    @Autowired
    private DarkSpyService service = new DarkSpyService();

    @RequestMapping("/darkspy")
    public @ResponseBody
    Object getMaxRate() throws Exception {
        System.out.println(service.getLastDaysTemp());
        return 0.0;
    }

}
