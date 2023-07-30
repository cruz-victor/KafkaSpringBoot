package com.ubicuosoft.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
@Slf4j
public class KafkaKeyProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String key, String message) throws InterruptedException {
        kafkaTemplate.send("t-multi-partitions",key,message);
        log.info("Producer--->");
        log.info("Key: {}",key);
        log.info("Message: {}",message);
        TimeUnit.SECONDS.sleep(1);
    }
}
