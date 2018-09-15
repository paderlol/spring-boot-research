package com.paderlol.spring.practice.properties.config;

import com.paderlol.spring.practice.properties.converter.GenericBigDecimalConverter;
import com.paderlol.spring.practice.properties.converter.StringToEnumConverterFactory;
import com.paderlol.spring.practice.properties.converter.StringToPersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author pader
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    StringToPersonConverter stringToPersonConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToPersonConverter);
        registry.addConverterFactory(new StringToEnumConverterFactory());
        registry.addConverter(new GenericBigDecimalConverter());
    }
}
