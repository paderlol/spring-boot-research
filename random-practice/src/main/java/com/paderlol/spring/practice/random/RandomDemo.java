package com.paderlol.spring.practice.random;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pader
 */
@ConfigurationProperties(prefix="test.random")
@Data
@NoArgsConstructor
@Component
public class RandomDemo {
    private String secret;
    private Integer number;
    private Long bigNumber;
    private String uuid;
    private Integer numberLessThanTen;
    private Integer rangeNumber;


}
