package com.paderlol.spring.practice.properties.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 例子来自于 spring-boot-samples
 *
 * @author pader
 */
@Component
@ConfigurationProperties(prefix = "demo.valid-custom")
@Validated
@Data
public class CustomValidatorProperties {

    /**
     * Sample host.
     */
    private String host;

    /**
     * Sample port.
     */
    private Integer port = 8080;
}

