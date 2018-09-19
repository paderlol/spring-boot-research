package com.paderlol.spring.practice.properties.config;

import com.paderlol.spring.practice.properties.validator.SamplePropertiesValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

/**
 * 自定义Validator
 *
 * @author pader
 */
@Configuration
public class CustomValidatorConfiguration {


    @Bean
    public static Validator configurationPropertiesValidator() {
        return new SamplePropertiesValidator();
    }
}
