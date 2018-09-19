package com.paderlol.spring.practice.properties.pojo;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

/**
 * @author pader
 */
@ConfigurationProperties("demo.duration")
@Component
@Data
public class DurationProperties {

    @DurationUnit(ChronoUnit.DAYS)
    private Duration second = Duration.ofSeconds(30);
    private Duration millis = Duration.ofMillis(30);
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration minutes = Duration.ofMinutes(30);


}


