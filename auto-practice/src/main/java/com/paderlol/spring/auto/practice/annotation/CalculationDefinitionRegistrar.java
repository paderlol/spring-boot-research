package com.paderlol.spring.auto.practice.annotation;

import com.paderlol.spring.auto.practice.service.CalculateService;
import com.paderlol.spring.auto.practice.service.Java7CalculateService;
import com.paderlol.spring.auto.practice.service.Java8CalculateService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过实现ImportBeanDefinitionRegistrar接口完成自动装备Bean注册
 * @author pader
 * @see ImportBeanDefinitionRegistrar
 */
public class CalculationDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public static final String JAVA_8 = "Java8";
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {
        String jdkVersion = System.getProperty("jdkVersion");
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(CalculateService.class, () -> {
                    if (JAVA_8.equals(jdkVersion)) {
                        return new Java8CalculateService();
                    } else {
                        return new Java7CalculateService();
                    }
                }).setScope(BeanDefinition.SCOPE_SINGLETON).setRole(BeanDefinition.ROLE_APPLICATION)
                .getBeanDefinition();

        registry.registerBeanDefinition("calculateService", beanDefinition);
    }
}
