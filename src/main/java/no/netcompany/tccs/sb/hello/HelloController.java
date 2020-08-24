package no.netcompany.tccs.sb.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String egen;
    private final String felles;

    public HelloController(@Value("${egen}") final String egen,
                           @Value("${felles}") final String felles) {
        this.egen = egen;
        this.felles = felles;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/hello")
    public String helloStranger() {
        return "Hello stranger!";
    }

    @GetMapping("/verdier")
    public String verdier() {
        return "Felles:" + felles + " Egen:" + egen;
    }
}
