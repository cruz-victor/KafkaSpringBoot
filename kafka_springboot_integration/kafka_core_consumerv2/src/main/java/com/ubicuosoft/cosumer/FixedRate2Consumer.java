package com.ubicuosoft.cosumer;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class FixedRate2Consumer {

    @KafkaListener(topics = "t-fixedrate-2")
    public void listener(String message){
        log.info("Consumer--->");
        log.info("Message: Counter: {}",message);
    }
}
