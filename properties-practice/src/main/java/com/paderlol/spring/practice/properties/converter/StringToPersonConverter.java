package com.paderlol.spring.practice.properties.converter;

import com.paderlol.spring.practice.properties.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author pader
 */
@Slf4j
@Component
@ConfigurationPropertiesBinding
public class StringToPersonConverter implements Converter<String, Person> {

    @Override
    public Person convert(String from) {
        log.info("使用[Converter]接口,转换数据={}", from);
        String[] data = from.split(",");
        return Person.builder().name(data[0]).age(Integer.parseInt(data[1])).build();
    }
}
