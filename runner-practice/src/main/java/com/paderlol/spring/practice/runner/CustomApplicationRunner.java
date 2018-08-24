package com.paderlol.spring.practice.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author pader
 */
@Service
@Order(value = Ordered.LOWEST_PRECEDENCE-2)
@Slf4j
public class CustomApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        log.info("系统启动完成回调ApplicationRunner接口");
    }
}
