### Spring WebMvc 自动化

> 本示例目的用于展示,在不使用Spring Boot,单独使用Spring WebMvc也能实现Spring Boot一样的效果,便于理解Spring Boot是如何做到自动化装配Spring WebMvc的。



#### 配置DispatcherServletConfiguration

```java
//用于替代app-context.xml中
//<context:component-scan base-package="com.paderlol.spring.web"/>
@ComponentScan(value = "com.paderlol.spring.web")
public class DispatcherServletConfiguration {
}
```



#### 实现AbstractAnnotationConfigDispatcherServletInitializer抽象类

**Servlet 3.0**开始新增了`ServletContainerInitializers` 用于替代以往的web.xml启动方式,可以进行容器初始化的工作**,Spring Web Mvc 3.1**就已经提供了`SpringServletContainerInitializer`实现了`ServletContainerInitializers`接口。容器会在启动时调用`onStartup`方法,并且调用标注在`SpringServletContainerInitializer`类上的`@HandlesTypes(WebApplicationInitializer.class)`的类进行初始化。



```java
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // dispatcher
        return new Class[]{DispatcherServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```





#### 打包运行

```powershell
$ mvn -Dmaven.test.skip -U clean package 
$ java -jar spring-webmvc-1.0.0-war-exec.jar  
```