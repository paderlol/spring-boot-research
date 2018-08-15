## 自定义自动装配

>实现根据系统属性判定Java版本,选择以不同的方式实现数字的累加

### 自动装配@Import三种方式
#### Bean注解
```java
public class CalculationConfiguration {

    @Bean
    public CalculateService calculateService() {
        String jdkVersion = System.getProperty("jdkVersion");
        if (CalculateService.JAVA_8.equals(jdkVersion)) {
            return new Java8CalculateService();
        } else {
            return new Java7CalculateService();
        }
    }

}
```
#### 实现ImportSelector接口
```java

public class CalculationConfigurationSelector implements ImportSelector {

    public static final String JAVA_8 = "Java8";

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String jdkVersion = System.getProperty("jdkVersion");

        if (JAVA_8.equals(jdkVersion)) {
            return new String[]{ Java8CalculateService.class.getName() };
        }
        return new String[]{ Java7CalculateService.class.getName() };
    }
}
```

#### 实现 ImportBeanDefinitionRegistrar 接口
```java

public class CalculationDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public static final String JAVA_8 = "Java8";
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {
        String jdkVersion = System.getProperty("jdkVersion");
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(CalculateService.class, () -> {
                    if (JAVA_8.equals(jdkVersion)) {
                        return new Java8CalculateService();
                    } else {
                        return new Java7CalculateService();
                    }
                }).setScope(BeanDefinition.SCOPE_SINGLETON).setRole(BeanDefinition.ROLE_APPLICATION)
                .getBeanDefinition();

        registry.registerBeanDefinition("calculateService", beanDefinition);
    }
}
```