### Spring WebMvc 手动配置

####  引入相关POM依赖

```xml
<dependencies>
        <!-- web mvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
        </dependency>
        <!-- servlet api 3.1-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- jstl jsp依赖包-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
    </dependencies>
```



#### 修改打包方式为War

```xml
<packaging>war</packaging>
```



#### 增加mvc application context 配置文件

```xml
<context:component-scan base-package="com.paderlol.spring.web"/>
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
```



#### 配置 web.xml

```xml
    <!-- 配置Spring DispatcherServlet-->
    <servlet>
        <servlet-name>app</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/app-context.xml</param-value>
        </init-param>
    </servlet>
    <!-- 映射路径 -->
    <servlet-mapping>
        <servlet-name>app</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```



#### 配置本地嵌入式Tomcat运行插件

修改Pom文件

```xml
<!-- Tomcat Maven 插件用于构建可执行 war -->
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.1</version>
            <executions>
                <execution>
                    <id>tomcat-run</id>
                    <goals>
                        <!-- 最终打包成可执行的jar包 -->
                        <goal>exec-war-only</goal>
                    </goals>
                    <phase>package</phase>
                    <configuration>
                        <!-- ServletContext 路径 -->
                        <path>/</path>
                    </configuration>
                </execution>
            </executions>
        </plugin>
```





#### 打包运行

```powershell
$ mvn -Dmaven.test.skip -U clean package 
$ java -jar spring-webmvc-1.0.0-war-exec.jar  
```
