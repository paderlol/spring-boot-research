package com.paderlol.spring.practice.properties.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author pader
 */
@Data
@Builder
public class Person {

    private String name;
    private Integer age;


}
