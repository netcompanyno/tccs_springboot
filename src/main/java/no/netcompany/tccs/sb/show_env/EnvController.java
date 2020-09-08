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
    public EnvController(final Environment environment,
                         final SbConfig sbConfig,
                         @Value("${spring.profiles}") final String env) {
        this.environment = environment;
        this.sbConfig = sbConfig;
        this.env = env;
    }

    @GetMapping("/env")
    String env() {
        final String profile1 = this.env;
        final String profile2 = environment.getActiveProfiles()[0];
        final String profile3 = sbConfig.getProfiles();

        return "Your environment is " + profile1 + ", " + profile2 + " and " + profile3;
    }
}
