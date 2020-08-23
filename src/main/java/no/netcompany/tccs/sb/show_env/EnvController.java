package no.netcompany.tccs.sb.show_env;

import no.netcompany.tccs.sb.config.SbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnvController {

    @Value("${spring.profiles}")
    private String env;

    Environment environment;

    @Autowired
    private SbConfig sbConfig;


    @RequestMapping("/env")
    @ResponseBody
    String env() {
        //return "Your environment is " + env;
        return "Your environment is " + sbConfig.getProfiles();
        //return "Your environment is " + environment.getActiveProfiles();
    }
}
