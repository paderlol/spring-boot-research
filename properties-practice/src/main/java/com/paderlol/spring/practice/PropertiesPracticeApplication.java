package com.paderlol.spring.practice;

import com.paderlol.spring.practice.properties.AcmeProperties;
import com.paderlol.spring.practice.properties.CollectionProperties;
import com.paderlol.spring.practice.properties.MapProperties;
import com.paderlol.spring.practice.properties.ThirdComponent;
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

    final
    MapProperties mapProperties;
    final
    CollectionProperties collectionProperties;

    final
    LanguageService languageService;

    final
    AcmeProperties acmeProperties;

    final
    ThirdComponent thirdComponent;

    public PropertiesPracticeApplication(MapProperties mapProperties,
            CollectionProperties collectionProperties, LanguageService languageService,
            AcmeProperties acmeProperties, ThirdComponent thirdComponent) {
        this.mapProperties = mapProperties;
        this.collectionProperties = collectionProperties;
        this.languageService = languageService;
        this.acmeProperties = acmeProperties;
        this.thirdComponent = thirdComponent;
    }

    public static void main(String[] args) {
        SpringApplication.run(PropertiesPracticeApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Third-party Configuration={}", thirdComponent.toString());
        log.info("Nested Bean Properties={}", acmeProperties.toString());
        log.info("Language Service={}", languageService.getLanguage());
        log.info("String Map Properties={}", mapProperties.getStringMap().entrySet());
        log.info("Entity Map Properties={}", mapProperties.getEntityMap().entrySet());
        log.info("String Collection Properties={}", collectionProperties.getStringList());
        log.info("Entity Collection Properties={}", collectionProperties.getEntityList());
    }
}
