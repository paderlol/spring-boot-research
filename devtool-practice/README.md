## Spring-Boot-Devtool 例子
> - 自定义触发重启文件
> - 自定义全局触发文件
### 自定义触发重启文件
```properties
# 配置触发重启的文件时需要注意,如果触发的文件名是放在项目目录下面,就必须要配置additional-paths
# 注意如果工程是父子工程监控上下文路径是指的父类工程
# 否则需要把触发文件放在编译后的/target/classes/目录下面，因为默认监控的就是这个文件夹下面的变动
# 默认监控整个项目目录 spring.devtools.restart.additional-paths=.
spring.devtools.restart.additional-paths=files
spring.devtools.restart.trigger-file=trigger
# 配置启动的时候系统完全安静的时间  注意单位一定要带ms 因为这里配置的实际是java.time.Duration
spring.devtools.restart.quiet-period=400ms
## 配置触发的扫描的间隔时间 时间单位s
spring.devtools.restart.poll-interval=1s

```
### 自定义全局触发文件
> - 配置在$HOME目录下，注意文件的开头一定有.符号
> - 文件名 **.spring-boot-devtools.properties**

```properties
# ~.spring-boot-devtools.properties
# 配置了触发文件 必须要指定监控触发文件的目录，比如 . 就是指的当前的项目的上下文，可以理解是当前项目的全部目录
spring.devtools.restart.additional-paths=.
spring.devtools.reload.trigger-file=.reloadtrigger
```

### 测试方法 
  - http://localhost:8081/dev/hello
  - http://localhost:8081/index.html

Note:建议Google浏览器安装一个[LiveReload](http://livereload.com/)插件,可以不用每次更改了后还需要刷新页面


