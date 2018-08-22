#### Application Events and Listeners

> 在Spring-Boot运行时，除了像[`ContextRefreshedEvent`](https://docs.spring.io/spring/docs/5.0.8.RELEASE/javadoc-api/org/springframework/context/event/ContextRefreshedEvent.html)这种Spring Framework events，`SpringApplication`还会发出一些特殊的事件

应用程序运行时，以下顺序发送应用程序事件

| Event                               | since version |
| ----------------------------------- | ------------- |
| ApplicationStartingEvent            | 1.5           |
| ApplicationEnvironmentPreparedEvent | 1.0           |
| ApplicationPreparedEvent            | 1.0           |
| ApplicationStartedEvent             | 2.0           |
| ApplicationReadyEvent               | 1.3           |
| ApplicationFailedEvent              | 1.0           |

事件解释：

1. **ApplicationStartingEvent**： 当程序初始化确定运行的容器类型，`ApplicationContextInitializer`，`ApplicationListener`之后， 运行方法(`run(args)`)首次运行时立即调用，通常可以用于做一些初始化工作比如日志配置，以及热部署等等
2. **ApplicationEnvironmentPreparedEvent**：在完成系统环境变量初始化之后，上下文创建之前,发出事件,通常用来读取系统配置，如读取`application.properties`
3. **ApplicationPreparedEvent**：在加载完Bean Definitions之后，但是在刷新上下文之前
4. **ApplicationStartedEvent**：刷新完成上下文,并且刷新上下文之后如果有web容器就启动容器，之后发送事件
5. **ApplicationReadyEvent**：当完成CommandRunner 和 ApplicationRunner 回调接口后发送
6. **ApplicationFailedEvent**：启动失败后,发送失败事件,默认都是生成失败报告 可实现`FailureAnalyzer`实现自定义错误报告分析

**Note:**

- `ApplicationStartingEvent`实际上应该是1.0就有这个事件了,但是当时的名称是`ApplicationStartedEvent`

- 在1.0和2.0中的`ApplicationStartedEvent` 虽然名字一样,但不是同一个事件,前者代表程序刚启动,后者代表程序已经启动完成，但未调用`CommandLineRunner`和`ApplicationRunner`实现接口