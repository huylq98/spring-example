package vn.com.huylq.springexample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import vn.com.huylq.springexample.service.UserService;

@SpringBootApplication
@EnableCaching
@RequiredArgsConstructor
@Slf4j
public class SpringExampleApplication {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringExampleApplication.class, args);
    }

}
