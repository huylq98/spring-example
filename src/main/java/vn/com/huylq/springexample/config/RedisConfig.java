package vn.com.huylq.springexample.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair.fromSerializer;

@Configuration
@ConditionalOnProperty(value = "cache.redis.enable", havingValue = "true")
@EnableConfigurationProperties(RedisConfigurationProperties.class)
public class RedisConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public RedisConnectionFactory lettuceConnectionFactory(RedisConfigurationProperties properties) {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(properties.getHost());
        configuration.setPort(properties.getPort());
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public CacheManager cacheManager(
            RedisConnectionFactory factory,
            RedisConfigurationProperties properties) {
        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();

        properties.getCacheExpirations()
                  .forEach((key, value) -> cacheConfigurations.put(key, cacheConfiguration(value)));

        return RedisCacheManager.builder(factory)
                                .withInitialCacheConfigurations(cacheConfigurations)
                                .build();
    }

    private RedisCacheConfiguration cacheConfiguration(long ttl) {
        return RedisCacheConfiguration.defaultCacheConfig()
                                      .disableCachingNullValues()
                                      .computePrefixWith(cacheName -> {
                                          StringBuilder prefix = new StringBuilder();
                                          prefix.append(applicationName).append(":");
                                          if (!StringUtils.isBlank(cacheName)) prefix.append(cacheName).append(":");
                                          return prefix.toString();
                                      })
                                      .entryTtl(Duration.ofSeconds(ttl))
                                      .serializeValuesWith(fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
}
