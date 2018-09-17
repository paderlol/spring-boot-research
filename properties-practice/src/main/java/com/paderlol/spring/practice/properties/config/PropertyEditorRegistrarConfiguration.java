package com.paderlol.spring.practice.properties.config;

import com.paderlol.spring.practice.properties.editor.CustomMovieEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pader
 */
@Configuration
public class PropertyEditorRegistrarConfiguration {


    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();

        customEditorConfigurer.setPropertyEditorRegistrars(
                new PropertyEditorRegistrar[]{ new CustomMovieEditor() });
        return customEditorConfigurer;
    }
}
