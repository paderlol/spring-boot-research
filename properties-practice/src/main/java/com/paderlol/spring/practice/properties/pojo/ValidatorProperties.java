package com.paderlol.spring.practice.properties.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 简单的属性验证包含嵌套属性
 *
 * @author pader
 */
@ConfigurationProperties("demo.valid")
@Component
@Validated
@Data
@Builder
public class ValidatorProperties {

    @Email
    @NotNull
    private String email;

    /**
     * @Valid注解可以关联嵌套属性,可以保证嵌套属性没有值也可以验证
     */
    @Valid
    private Security security;

    @Data
    @Builder
    public static class Security {

        @NotBlank(message = "userName must be not null")
        private String userName;

        @NotBlank(message = "password must be not null")
        private String password;

        @NotEmpty
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

    }
}
