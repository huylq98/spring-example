package vn.com.huylq.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringExampleApplication.class, args);
    }

}
