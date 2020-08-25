package no.netcompany.tccs.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SbApp{

    public static void main(String[] args) {
        SpringApplication.run(SbApp.class, args);
    }
}