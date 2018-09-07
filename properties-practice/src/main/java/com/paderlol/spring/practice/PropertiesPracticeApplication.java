package com.paderlol.spring.practice;

import com.paderlol.spring.practice.properties.AcmeProperties;
import com.paderlol.spring.practice.properties.CollectionProperties;
import com.paderlol.spring.practice.properties.MapProperties;
import com.paderlol.spring.practice.properties.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pader
 */
@SpringBootApplication
@Slf4j
public class PropertiesPracticeApplication implements CommandLineRunner {

    @Autowired
    MapProperties mapProperties;
    @Autowired
    CollectionProperties collectionProperties;

    @Autowired
    LanguageService languageService;

    @Autowired
    AcmeProperties acmeProperties;

    public static void main(String[] args) {
        SpringApplication.run(PropertiesPracticeApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Nested Bean Properties={}", acmeProperties.toString());
        log.info("Language Service={}", languageService.getLanguage());
        log.info("String Map Properties={}", mapProperties.getStringMap().entrySet());
        log.info("Entity Map Properties={}", mapProperties.getEntityMap().entrySet());
        log.info("String Collection Properties={}", collectionProperties.getStringList());
        log.info("Entity Collection Properties={}", collectionProperties.getEntityList());
    }
}
