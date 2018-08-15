package com.paderlol.spring.auto.customize.service;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Java 8 Lambda 方式进行求和计算
 * @see CalculateService
 */
@Slf4j
public class Java8CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        log.info("Java8 Lambda 求和计算");
        return Arrays.stream(values).reduce(0, Integer::sum);
    }


}
