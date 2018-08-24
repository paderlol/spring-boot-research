#### 接收应用参数

> - 如果需要在运行时需要使用系统参数`SpringApplication.run(mainClass,args)`,可以通过注入参数`org.springframework.boot.ApplicationArguments` bean
> - 通过`@Value`的形式进行注入,但是必须是遵循`CommandLinePropertySource`的规范



**Note**:如果使用`@Value`注解进行注入的系统参数,需要符合`CommandLinePropertySource`定义的规范：

```properties
#在声明系统参数时必须带上 -- 符号
--foo //空
--foo=bar //
--foo="bar then baz" 字符串
--foo=bar,baz,biz //数组 使用@Value注入时 可以是数组也可以是字符串
```

具体如何解析生成参数的源码（默认`SimpleCommandLineArgsParser`)

```java
public CommandLineArgs parse(String... args) {
		CommandLineArgs commandLineArgs = new CommandLineArgs();
		for (String arg : args) {
			if (arg.startsWith("--")) { //判断是否以--开头
				String optionText = arg.substring(2, arg.length());
				String optionName;
				String optionValue = null;
				if (optionText.contains("=")) {//判断是否包含=号
					optionName = optionText.substring(0, optionText.indexOf('='));
					optionValue = optionText.substring(optionText.indexOf('=')+1, optionText.length());
				}
				else {
					optionName = optionText;
				}
				if (optionName.isEmpty() || (optionValue != null && optionValue.isEmpty())) {
					throw new IllegalArgumentException("Invalid argument syntax: " + arg);
				}
				commandLineArgs.addOptionArg(optionName, optionValue);
			}
			else {//没有--开头的参数 直接归类到NonOptionArg
				commandLineArgs.addNonOptionArg(arg);
			}
		}
		return commandLineArgs;
	}
```





#### ApplicationRunner or CommandLineRunner

> - 如果需要有些代码在**SpringApplication**启动后马上运行,可以实现**ApplicationRunner**或者**CommandLineRunner**接口
> - 当实际使用中**ApplicationRunner**或者**CommandLineRunner**接口需要排序时，可以实现`org.springframework.core.Ordered`接口或者`org.springframework.core.annotation.Order`注解
>
>