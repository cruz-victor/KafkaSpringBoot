package com.ubicuosoft.cosumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubicuosoft.entity.CarLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarLocationConsumer {

    @Autowired
    private ObjectMapper objectMapper;


    @KafkaListener(topics = "t-location", groupId = "cg-all-location")
    public void listenAll(String message) throws JsonProcessingException {
        var car=objectMapper.readValue(message, CarLocation.class);
        log.info("Consumer All---> {}", message);
    }

//    @KafkaListener(topics = "t-location", groupId = "cg-far100-location")
//    public void listenFar100km(String message) throws JsonProcessingException {
//        var car=objectMapper.readValue(message,CarLocation.class);
//        if (car.getDistance()<100){
//            return;
//        }
//        log.info("Consumer far100---> {}", message);
//    }

    @KafkaListener(topics = "t-location", groupId = "cg-far100-location", containerFactory = "farLocaltionContinerFactory")
    public void listenFar100km(String message) throws JsonProcessingException {
        var car=objectMapper.readValue(message,CarLocation.class);
        log.info("Consumer far100---> {}", message);
    }
}
