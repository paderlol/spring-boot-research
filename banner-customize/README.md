#### 自定义Banner

> - 默认可以在`src/main/resources`目录下定义**banner.txt**，来改变程序启动时打印的Banner
> - 如果需要放在自定义的位置,就需要配置**spring.banner.location**
> - 如果文件的编码不是**UTF-8**(默认),那么需要指定**spring.banner.charset**
> - 除了指定`.txt`以外,还可以直接制定`banner.gif`, `banner.jpg`,或者 `banner.png`，默认也是在`src/main/resources`目录下面
> - 如果需要自定义图片位置可以配置`spring.banner.image.location`

在自己定义的banner.txt中可以使用以下的变量：

| 变量名                         | 描述                                  |
| :------------------------------- | :------------------------------------------- |
| ${application.version}           | 打印应用程序版本号                           |
| ${application.formatted-version} | 打印应用程序版本号,不过会在版本号带前缀**v** |
| ${spring-boot.version}           | Spring-Boot 版本号                           |
| ${spring-boot.formatted-version} | 前缀带**v**Spring-Boot 版本号                |
| ${application.title}             | 应用名称                                     |

```verilog
  _____          _
 |  __ \        | |
 | |__) |_ _  __| | ___ _ __
 |  ___/ _` |/ _` |/ _ \ '__|
 | |  | (_| | (_| |  __/ |
 |_|   \__,_|\__,_|\___|_|
                              
  :: Application Title ::  banner-customize
  :: Spring-Boot Version ::   2.0.4.RELEASE
  :: Application Version ::   1.0.0
  :: Application Formatted-Version ::    (v1.0.0)
  :: Spring-Boot Formatted-Version ::    (v2.0.4.RELEASE)
```