package no.netcompany.tccs.sb.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping("/hello")
    public String helloStranger() {
        return "Hello stranger!";
    }
}