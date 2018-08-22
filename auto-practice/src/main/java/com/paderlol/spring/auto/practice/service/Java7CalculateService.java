package com.paderlol.spring.auto.practice.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Java7 求和方式
 * @see CalculateService
 */
@Slf4j
public class Java7CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        log.info("Java7 求和计算");
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
