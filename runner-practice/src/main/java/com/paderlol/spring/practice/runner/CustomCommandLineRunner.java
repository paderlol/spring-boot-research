package com.paderlol.spring.practice.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author pader
 */
@Service
@Order(value = Ordered.LOWEST_PRECEDENCE-1)
@Slf4j
public class CustomCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("系统启动完成回调CommandLineRunner接口");
    }
}
