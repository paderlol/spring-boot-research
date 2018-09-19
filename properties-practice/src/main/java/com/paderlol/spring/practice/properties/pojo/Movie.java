package com.paderlol.spring.practice.properties.pojo;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@ConfigurationProperties("demo.movie")
public class Movie {

    private String name;
    private Integer seat;

}
