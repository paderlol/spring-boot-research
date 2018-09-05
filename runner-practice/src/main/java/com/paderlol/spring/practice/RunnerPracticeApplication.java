package com.paderlol.spring.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pader
 */
@SpringBootApplication
public class RunnerPracticeApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RunnerPracticeApplication.class);
        application.setAddCommandLineProperties(false);
        application.run(args);
    }
}
