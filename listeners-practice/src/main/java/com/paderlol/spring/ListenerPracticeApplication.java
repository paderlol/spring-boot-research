package com.paderlol.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

/**
 * @author pader
 */
@SpringBootApplication
public class ListenerPracticeApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ListenerPracticeApplication.class);
        application.setApplicationContextClass(AnnotationConfigServletWebServerApplicationContext.class);
        application.run(args);

        new SpringApplicationBuilder(ListenerPracticeApplication.class)
                .contextClass(AnnotationConfigServletWebServerApplicationContext.class).run(args);
    }
}
