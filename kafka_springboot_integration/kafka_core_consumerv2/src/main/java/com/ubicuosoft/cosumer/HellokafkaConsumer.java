package com.ubicuosoft.cosumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class HellokafkaConsumer {

    @KafkaListener(topics = "t-hello")
    public void listener(String message){
        System.out.println("Consumer--->");
        System.out.println("Message: "+message);
    }
}
