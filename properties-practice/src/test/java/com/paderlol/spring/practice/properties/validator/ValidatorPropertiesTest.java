package com.paderlol.spring.practice.properties.validator;

import static org.assertj.core.api.Assertions.assertThat;

import com.paderlol.spring.practice.PropertiesPracticeApplication;
import com.paderlol.spring.practice.properties.pojo.ValidatorProperties;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 */
public class ValidatorPropertiesTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    public final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @After
    public void after() {
        this.context.close();

    }

    @Before
    public void before() {
        this.context.register(PropertiesPracticeApplication.class);
        TestPropertyValues.of("demo.valid-custom.host:192.168.0.1", "demo.valid-custom.port:9090")
                .applyTo(this.context);
    }


    @Test
    public void bindValidProperties() {

        TestPropertyValues.of("demo.valid.email:11111@qq.com", "demo.valid.security.userName:pader",
                "demo.valid.security.password:123456")
                .applyTo(this.context);
        this.context.refresh();

        ValidatorProperties properties = this.context
                .getBean(ValidatorProperties.class);
        //因为上下文取出来的是一个代理对象会导致比对失败,所以把数据拿出来重新设置一下
        ValidatorProperties actualValidatorProperties = ValidatorProperties.builder().email(properties.getEmail()).security(properties.getSecurity()).build();
        ValidatorProperties.Security security = ValidatorProperties.Security.builder()
                .userName("pader").password("123456").roles(Collections.singletonList("USER"))
                .build();
        ValidatorProperties expectedValidatorProperties = ValidatorProperties.builder()
                .email("11111@qq.com").security(security).build();

        assertThat(actualValidatorProperties).isEqualToComparingFieldByField(expectedValidatorProperties);
    }

    @Test
    public void bindInvalidEmail() {

        TestPropertyValues.of("demo.valid.email:xxxx", "demo.valid.security.userName:pader",
                "demo.valid.security.password:123456")
                .applyTo(this.context);

        this.thrown.expect(BeanCreationException.class);
        this.thrown.expectMessage("Failed to bind properties under 'demo.valid'");
        this.context.refresh();
    }

    @Test
    public void bindNullHost() {
        this.thrown.expect(BeanCreationException.class);
        this.thrown.expectMessage("Failed to bind properties under 'demo.valid'");
        this.context.refresh();
    }


}
