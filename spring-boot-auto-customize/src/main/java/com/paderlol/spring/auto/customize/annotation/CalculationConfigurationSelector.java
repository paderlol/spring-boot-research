package com.paderlol.spring.auto.customize.annotation;

import com.paderlol.spring.auto.customize.service.Java7CalculateService;
import com.paderlol.spring.auto.customize.service.Java8CalculateService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过系统属性判断传入的jdk版本来选择具体执行计算的服务
 * @author pader
 * @see ImportSelector
 */
public class CalculationConfigurationSelector implements ImportSelector {

    public static final String JAVA_8 = "Java8";

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String jdkVersion = System.getProperty("jdkVersion");

        if (JAVA_8.equals(jdkVersion)) {
            return new String[]{ Java8CalculateService.class.getName() };
        }
        return new String[]{ Java7CalculateService.class.getName() };
    }
}
