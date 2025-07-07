package br.com.desafio.desafio_globo.cache;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory redisConnectionFactory) {
    	

        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(10))
                .disableCachingNullValues();                

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(config)
                .build();
   }
    
	
    @Bean
    public CommandLineRunner redisHelthCheck(StringRedisTemplate redisTemplate) {
        return args -> {
            Logger logger = LoggerFactory.getLogger("RedisHelthCheck");
            logger.info(System.getenv().toString());
            try {
                redisTemplate.opsForValue().set("redis:ping", "pong");
                String value = redisTemplate.opsForValue().get("redis:ping");
                logger.info("Conexão com Redis estabelecida. Valor de teste: {}", value);
            } catch (Exception e) {
                logger.error("Falha ao conectar com Redis: {}", e.getMessage(), e);
            }
        };
    }
}



