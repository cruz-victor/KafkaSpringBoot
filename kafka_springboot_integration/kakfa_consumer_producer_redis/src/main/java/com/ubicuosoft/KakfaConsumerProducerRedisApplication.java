package com.ubicuosoft;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.ubicuosoft","com.ubicuosoft.redis.repository"})
public class KakfaConsumerProducerRedisApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KakfaConsumerProducerRedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      log.info("Hola vic");
    }
}
