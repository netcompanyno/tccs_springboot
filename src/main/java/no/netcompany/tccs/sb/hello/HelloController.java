package no.netcompany.tccs.sb.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${egen}")
    private String egen;

    @Value("${felles}")
    private String felles;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping("/hello")
    public String helloStranger() {
        return "Hello stranger!";
    }

    @RequestMapping("/verdier")
    public String verdier() {
        return "Felles:" + felles + " Egen:" + egen;
    }
}
