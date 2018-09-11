#### Application 属性文件

> Spring Boot 加载 `application.properties`文件默认通过以下位置进行加载：
>
> 1. `file:./config` 当前项目目录下面的config文件夹,如果是父子工程,那么就是以父工程为准,这似乎是Spring-Boot的一个小bug
> 2. `file:./` 当前项目目录下面
> 3. `classpath:/config/`
> 4. `classpath:/`



#### Profile配置属性

> - 除application.properties文件外，还可以使用以下命名约定定义特定于配置文件的属性：application- {profile} .properties
> - 环境具有一组默认配置文件（默认情况下为[默认]），如果未设置活动配置文件，则使用这些配置文件。换句话说，如果未显式激活任何配置文件，则会加载application-default.properties中的属性。
> - 特定于配置文件的文件始终覆盖非特定文件，无论特定于配置文件的文件是在打包的jar内部还是外部。
> - 如果指定了多个配置文件，则应用last-wins策略。例如，spring.profiles.active属性指定的配置文件是在通过SpringApplication API配置的配置文件之后添加的,因为上述的last-wins策略所以保持特殊文件的优先



**Note:** 注意如果使用`spring.config.location`直接定义配置文件，会导致application- {profile} .properties这种特殊配置文件失效,所以如果希望使用application- {profile} .properties这种特殊配置文件,在使用`spring.config.location`时需要只使用目录



**激活属性加载顺序**:`application.properties` < `spring.profiles.include` < spring.profiles.active



**Note**：注意在多个`application.properties`文件中如果有多个`spring.profiles.active`只会加载一次,`spring.profiles.include`可以加载多次,也就是说如果在`spring.profiles.active`激活的属性文件中再次配置`spring.profiles.active`属性是不会生效的,如果需要在激活的属性文件中使用profile,可以使用`spring.profiles.include`



**小技巧**：实际开发中,可以利用注解派生性,对**@Profile**注解进行派生

```java

@Target({ ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Profile("english")
public @interface English {
    /**
     * The set of profiles for which the annotated component should be registered.
     */
    @AliasFor(annotation = Profile.class)
    String value() default "";
}
```





#### 属性占位符

> 在`application.properties`里面可以使用`${}`占位符的方式引用当前属性文件的的属性或者外部属性,例如system环境变量



#### 多环境Yaml

> 在**Yaml**格式的属性文件下,可以把多个环境的文件合成一个文件进行定义,如下

```yaml
spring:
  application:
    name: "random-practice"
  profiles:
    active: dev
    include: prod
---
spring:
     profiles: dev
server:
  address: 127.0.0.1
  port: 8882
---
spring:
  profiles: prod
server:
  address: 127.0.0.1
  port: 8881
```



#### YAML 缺点

> 不能通过`@PropertySource` 注解引用Yaml文件

#### 安全的属性对象

> 使用@Value（“$ {property}”）注释来注入配置属性有时会很麻烦，特别是如果您正在使用多个属性或者您的数据本质上是分层的。Spring Boot提供了一种使用属性的替代方法，该方法允许强类型bean管理和验证应用程序的配置，如以下示例所示：

```java

/**
 * 嵌套属性对象
 *
 * @author pader
 */
@ConfigurationProperties("acme")
@Component
@Getter
@Setter
@ToString
public class AcmeProperties {

    private boolean enabled;

    private InetAddress remoteAddress;

    private final Security security = new Security();


    @Setter
    @Getter
    @ToString
    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

    }
}
```

> 注意几个规则:
>
> 1. 如果是Map或者List类型,如果声明了初始化,那么可以不用添加setter函数,但是通常**建议还是加上**
> 2. 如果使用**lombok**来简化**getter**和**setter**工作,那么需要注意不要提供有参的构造函数,否则可能spring注入会出现问题
> 3. 如果是嵌套属性,如上述例子中的“Security”字段,则可以不用setter,但是如果是通过构造函数注入则需要提供setter
> 4. 目前不支持静态字段的注入

#### 第三方配置

> 除了把@`ConfigurationProperties`注解使用在类上,还可以把这个注解使用在带有**@Bean**注解的**方法**上面
>
> 场景主要在:引入第三方类的场景下,如下

```java
/**
 * @author pader
 */
@Configuration
public class ThirdConfiguration {

    @ConfigurationProperties("third")
    @Bean
    public ThirdComponent thirdComponent(){
        return new ThirdComponent();
    }
}
```

