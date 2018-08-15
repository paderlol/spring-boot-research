package com.paderlol.spring.auto.customize.annotation;

import com.paderlol.spring.auto.customize.service.CalculateService;
import com.paderlol.spring.auto.customize.service.Java7CalculateService;
import com.paderlol.spring.auto.customize.service.Java8CalculateService;
import org.springframework.context.annotation.Bean;

public class CalculationConfiguration {

    @Bean
    public CalculateService calculateService() {
        String jdkVersion = System.getProperty("jdkVersion");
        if (CalculateService.JAVA_8.equals(jdkVersion)) {
            return new Java8CalculateService();
        } else {
            return new Java7CalculateService();
        }
    }

}
