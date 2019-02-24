### Spring WebMvc 注解配置



#### 删除app-context.xml中 对RequestMapping的配置

```xml
 <!--<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>-->
    <!--<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>-->
    <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
        <!--<property name="prefix" value="/WEB-INF/jsp/"/>-->
        <!--<property name="suffix" value=".jsp"/>-->
    <!--</bean>-->
```



#### 编写WebMvcConfig类

`WebMvcConfig` 类用于代替配置在app-context.xml中的内容,`@EnableWebMvc`这个注解很重要,算是一种编程方式替换xml的配置内容,里面利用`@Import(DelegatingWebMvcConfiguration.class)`来完成之前xml中配置的功能.

```java
/**
 * @author paderlol
 * @date: 2019-02-24 15:18
 */
@Configuration
//这个注解
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    //    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
//        <property name="prefix" value="/WEB-INF/jsp/"/>
//        <property name="suffix" value=".jsp"/>
//    </bean>
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("intercepting .......");
                return true;

            }
        });
    }
}
```



#### 打包运行

```powershell
$ mvn -Dmaven.test.skip -U clean package 
$ java -jar spring-webmvc-1.0.0-war-exec.jar  
```