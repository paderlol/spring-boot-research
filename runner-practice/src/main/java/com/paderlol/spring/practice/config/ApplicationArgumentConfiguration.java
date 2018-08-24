package com.paderlol.spring.practice.config;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author pader
 *  在系统启动参数上配置
 *  --foo
 *  --foo=bar
 *  --foo="bar then baz"
 *  --foo=bar,baz,biz
 *
 */
@Slf4j
@Configuration
public class ApplicationArgumentConfiguration {

    @Bean
    public MyBean myBean1(@Value("${foo:default}")List<String> foo){
      log.info("通过注解引用系统参数={}",foo);

        return new MyBean();
    }

    @Bean
    public MyBean myBean2(ApplicationArguments arguments){
        log.info("通过注入ApplicationArguments引用系统参数={}",arguments.getOptionValues("foo"));

        return new MyBean();
    }
}
