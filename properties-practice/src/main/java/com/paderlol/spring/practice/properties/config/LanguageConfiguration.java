package com.paderlol.spring.practice.properties.config;

import com.paderlol.spring.practice.properties.annotation.Chinese;
import com.paderlol.spring.practice.properties.annotation.English;
import com.paderlol.spring.practice.properties.service.LanguageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pader
 */
@Configuration
public class LanguageConfiguration {

    @English
    @Bean
    public LanguageService english() {
        return () -> "English";
    }

    @Chinese
    @Bean
    public LanguageService chinese() {
        return () -> "Chinese";
    }
}
