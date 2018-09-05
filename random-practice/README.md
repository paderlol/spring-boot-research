#### 随机值配置

> `RandomValuePropertySource`用于注入随机数，它能提供integers, longs, uuids, or strings

例子：application配置

```properties
spring:
  application:
    name: "random-practice"
test:
  random:
    secret: ${random.value}
    number: ${random.int}
    big-number: ${random.long}
    uuid: ${random.uuid}
    number-less-than-ten: ${random.int(10)}
    range-number: ${random.int[1024,65536]}
```

