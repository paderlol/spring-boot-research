package com.paderlol.spring.practice.properties.pojo;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pader
 */
@ConfigurationProperties("map.practice")
@Getter
@Component
public class MapProperties {

    private final Map<String, String> stringMap = new HashMap<>();
    private final Map<String, Person> entityMap = new HashMap<>();
    private final Map<String, Movie> movieMap = new HashMap<>();

}
