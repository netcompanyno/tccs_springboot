package no.netcompany.tccs.sb.show_env;

import no.netcompany.tccs.sb.config.SbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    @Value("${spring.profiles}")
    private String env;

    private Environment environment;

    private final SbConfig sbConfig;

    @Autowired
    public EnvController(final SbConfig sbConfig) {
        this.sbConfig = sbConfig;
    }

    @GetMapping("/env")
    String env() {
        //return "Your environment is " + env;
        return "Your environment is " + sbConfig.getProfiles();
        //return "Your environment is " + environment.getActiveProfiles();
    }
}
