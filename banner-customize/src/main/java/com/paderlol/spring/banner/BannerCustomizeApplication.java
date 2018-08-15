package com.paderlol.spring.banner;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author pader
 */
@SpringBootApplication
public class BannerCustomizeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BannerCustomizeApplication.class).web(WebApplicationType.NONE)
//                .bannerMode(Mode.OFF) //OFF CONSOLE LOG 默认CONSOLE
                .run();
    }
}
