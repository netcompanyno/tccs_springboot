package no.netcompany.tccs.sb.show_env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnvController {

    @Value("${server.env}")
    private String env;

    @RequestMapping("/env")
    @ResponseBody
    String env() {
        return "Your environment is " + env;
    }
}
