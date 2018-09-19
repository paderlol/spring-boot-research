package com.paderlol.spring.practice.properties.pojo;

import com.paderlol.spring.practice.properties.pojo.Person;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pader
 */
@Component
@ConfigurationProperties("demo.collection")
@Getter
public class CollectionProperties {

    private final List<String> stringList= new ArrayList<>();
    private final List<Person> entityList = new ArrayList<>();

}
