package com.ubicuosoft.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class HelloKafkaProducer {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message){
        log.info("Producer--->");
        log.info("Message: {}",message);
        kafkaTemplate.send("t-hello", message);
    }
}
