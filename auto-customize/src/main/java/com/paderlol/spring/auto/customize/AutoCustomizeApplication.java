package com.paderlol.spring.auto.customize;

import com.paderlol.spring.auto.customize.service.CalculateService;
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
public class AutoCustomizeApplication implements CommandLineRunner {

    @Autowired
    private CalculateService calculateService;

    public static void main(String[] args) {
        //Java7 or Java8
        System.setProperty("jdkVersion", "Java8");
        SpringApplication.run(AutoCustomizeApplication.class);
    }

    @Override
    public void run(String... args) {
        log.info("求和结果={}",calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
