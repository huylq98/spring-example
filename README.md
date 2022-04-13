# spring-example

## 1. Tech Stack

* Frameworks: Spring Boot, Spring JPA.
* Cache: Redis.
* Database: H2.
* Build tool: Maven.
* Techniques:
    * Using `@RestControllerAdvice` to handle exceptions globally.
    * Using Mapstruct to convert between models.
    * Using `Filter` and `@ControllerAdvice` to log requests and responses.

## 2. Caching using Redis

**Step 1:** Add following dependencies to `pom.xml`

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

**Step 2:** Enable `@EnableCaching`

**Step 3:** Custom configuration (See `vn.com.huylq.springexample.config.RedisConfig`)
* Config `RedisConnectionFactory`: connect to redis server
* Config `CacheManager`: configuration for every cache

**Step 4:** Use annotation provided by Spring Cache Abstraction:
* `@Cacheable`
* `@CachePut`
* `@CacheEvict`