package com.paderlol.spring.practice.properties.validator;

import static org.assertj.core.api.Assertions.assertThat;

import com.paderlol.spring.practice.PropertiesPracticeApplication;
import com.paderlol.spring.practice.properties.pojo.CustomValidatorProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomValidatorPropertiesTest {

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
        TestPropertyValues.of("demo.valid.email:11111@qq.com", "demo.valid.security.userName:pader",
                "demo.valid.security.password:123456")
                .applyTo(this.context);
    }

    @Test
    public void bindValidProperties() {

        TestPropertyValues.of("demo.valid-custom.host:192.168.0.1", "demo.valid-custom.port:9090")
                .applyTo(this.context);
        this.context.refresh();
        CustomValidatorProperties properties = this.context
                .getBean(CustomValidatorProperties.class);
        assertThat(properties.getHost()).isEqualTo("192.168.0.1");
        assertThat(properties.getPort()).isEqualTo(Integer.valueOf(9090));
    }

    @Test
    public void bindInvalidHost() {
        TestPropertyValues.of("demo.valid-custom.host:xxxxxx", "demo.valid-custom.port:9090")
                .applyTo(this.context);
        this.thrown.expect(BeanCreationException.class);
        this.thrown.expectMessage("Failed to bind properties under 'demo.valid-custom'");
        this.context.refresh();
    }

    @Test
    public void bindNullHost() {
        this.thrown.expect(BeanCreationException.class);
        this.thrown.expectMessage("Failed to bind properties under 'demo.valid-custom'");
        this.context.refresh();
    }

    @Test
    public void validatorOnlyCalledOnSupportedClass() {
        this.context.register(ServerProperties.class); // our validator will not apply
        TestPropertyValues.of("demo.valid-custom.host:192.168.0.1", "demo.valid-custom.port:9090")
                .applyTo(this.context);
        this.context.refresh();
        CustomValidatorProperties properties = this.context
                .getBean(CustomValidatorProperties.class);
        assertThat(properties.getHost()).isEqualTo("192.168.0.1");
        assertThat(properties.getPort()).isEqualTo(Integer.valueOf(9090));
    }
}
