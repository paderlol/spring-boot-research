package com.paderlol.spring.practice.properties.pojo;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 嵌套属性对象
 *
 * @author pader
 */
@ConfigurationProperties("demo.acme")
@Component
@Getter
@Setter
@ToString
public class AcmeProperties {

    private boolean enabled;

    private InetAddress remoteAddress;

    private Security security ;


    @Setter
    @Getter
    @ToString
    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

    }
}