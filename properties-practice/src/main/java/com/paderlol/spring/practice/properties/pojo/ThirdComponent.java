package com.paderlol.spring.practice.properties.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 第三方配置类
 * @author pader
 */
@Data
@ToString
public class ThirdComponent {

    private String url;
    private int port;
    private boolean enable;
}
