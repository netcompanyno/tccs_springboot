package no.netcompany.tccs.sb.show_env;

import no.netcompany.tccs.sb.config.SbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    private final String env;
    private final SbConfig sbConfig;

    private Environment environment;

    @Autowired
    public EnvController(final SbConfig sbConfig,
                         @Value("${spring.profiles}") final String env) {
        this.sbConfig = sbConfig;
        this.env = env;
    }

    @GetMapping("/env")
    String env() {
        //return "Your environment is " + env;
        return "Your environment is " + sbConfig.getProfiles();
        //return "Your environment is " + environment.getActiveProfiles();
    }
}
