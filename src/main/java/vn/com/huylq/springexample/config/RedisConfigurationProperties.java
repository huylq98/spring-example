package vn.com.huylq.springexample.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "cache.redis")
@Data
public class RedisConfigurationProperties {
    private String host = "127.0.0.1";
    private int port = 6379;
    private long timeoutSeconds = 10;

    // Mapping cacheNames with respective time-to-live
    private Map<String, Long> cacheExpirations = new HashMap<>();
}
