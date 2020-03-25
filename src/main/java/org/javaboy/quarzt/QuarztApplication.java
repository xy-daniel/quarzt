package org.javaboy.quarzt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuarztApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuarztApplication.class, args);
    }

}
