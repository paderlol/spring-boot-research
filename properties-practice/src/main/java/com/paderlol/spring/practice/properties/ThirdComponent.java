package com.paderlol.spring.practice.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 第三方配置类
 * @author pader
 */
@Setter
@Getter
@ToString
public class ThirdComponent {

    private String url;
    private String port;
    private String enable;
}
