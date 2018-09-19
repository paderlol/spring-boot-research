package com.paderlol.spring.practice.properties.config;

import com.paderlol.spring.practice.properties.pojo.ThirdComponent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pader
 */
@Configuration
public class ThirdConfiguration {

    @ConfigurationProperties("demo.third")
    @Bean
    public ThirdComponent thirdComponent(){
        return new ThirdComponent();
    }
}
