package com.upperapps.sakila.sakilaaddressservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication(exclude = [RedisRepositoriesAutoConfiguration::class])
@EnableCaching
class SakilaAddressServiceApplication

fun main(args: Array<String>) {
    runApplication<SakilaAddressServiceApplication>(*args)
}
