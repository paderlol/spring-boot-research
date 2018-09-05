package com.paderlol.spring.practice;

import com.paderlol.spring.practice.random.RandomDemo;
import java.util.Arrays;
import java.util.TimeZone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.util.calendar.ZoneInfo;

/**
 * @author pader
 */
@SpringBootApplication
@Slf4j
public class RandomPracticeApplication implements CommandLineRunner {

    @Autowired
    RandomDemo randomDemo;

    public static void main(String[] args) {
        SpringApplication.run(RandomPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("random.value = {}", randomDemo.getSecret());
        log.info("random.int = {}", randomDemo.getNumber());
        log.info("random.long = {}", randomDemo.getBigNumber());
        log.info("random.uuid = {}", randomDemo.getUuid());
        log.info("random.int(10) = {}", randomDemo.getNumberLessThanTen());
        log.info("random.int[1024,65536] = {}", randomDemo.getRangeNumber());
    }
}
