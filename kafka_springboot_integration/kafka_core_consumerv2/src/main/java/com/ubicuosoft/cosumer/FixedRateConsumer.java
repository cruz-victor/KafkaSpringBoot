package com.ubicuosoft.cosumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class FixedRateConsumer {
    @KafkaListener(topics = "t-fixedrate")
    public void listener(String message){
        log.info("Consumer--->");
        log.info("Message :{}",message);
    }
}
