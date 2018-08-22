package com.paderlol.spring.context.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author pader
 */
@Slf4j
public class CustomRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;

    public CustomRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;

    }

    @Override
    public void starting() {
        System.out.println(
                "初始化完成 ApplicationContextInitializer 实现 共计 " + application.getInitializers().size()
                        + "个,系统开始启动"
        );
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("完成系统环境变量初始化",
                environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

        log.info("完成上下文的环境变量设置以及上下文的前置处理,然后执行ApplicationContextInitializer");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("完成Bean Definitions 加载, 加载个数={}",
                context.getBeanDefinitionCount());
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("刷新完成上下文,并且启动完成Web容器");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("执行完CommandRunner 和 ApplicationRunner 回调接口实现");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("启动失败");
    }
}
