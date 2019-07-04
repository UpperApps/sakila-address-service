package com.upperapps.sakila.sakilaaddressservice.config

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

@Configuration
@PropertySource("classpath:application.yml")
class RedisConfig(val environment: Environment) {

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        val redisConfig = RedisStandaloneConfiguration().also {
            it.hostName = environment.getProperty("spring.redis.host")!!
            it.password = RedisPassword.of(environment.getProperty("spring.redis.password"))
            it.port = environment.getProperty("spring.redis.port")!!.toInt()
        }
        return LettuceConnectionFactory(redisConfig)
    }

    @Bean
    fun cacheConfiguration(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(600))
                .disableCachingNullValues()
    }

    @Bean
    fun cacheManager(): RedisCacheManager {
        return RedisCacheManager.builder(redisConnectionFactory())
                .cacheDefaults(cacheConfiguration())
                .transactionAware()
                .build()
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {

        val objectMapper = ObjectMapper()
        // Specify the fields, get and set to be serialized, and the range of modifiers.
        // ANY includes both private and public.
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
        // Specify the type of serialized input, the class must be non-final modified, final modified classes,
        // such as String,Integer, etc., will run out of exceptions
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)

        //Use Jackson 2Json RedisSerializer to serialize and deserialize the value of redis (default JDK serialization)
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(javaClass)
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper)

        val redisTemplate = RedisTemplate<String, Any>()
        redisTemplate.setConnectionFactory(redisConnectionFactory())
        // Values are serialized using json
        redisTemplate.valueSerializer = jackson2JsonRedisSerializer
        //Use String RedisSerializer to serialize and deserialize the key value of redis
        redisTemplate.keySerializer = StringRedisSerializer()
        // Setting hash key and value serialization mode
        redisTemplate.hashKeySerializer = StringRedisSerializer()
        redisTemplate.hashValueSerializer = jackson2JsonRedisSerializer
        redisTemplate.afterPropertiesSet()

        return redisTemplate
    }
}
