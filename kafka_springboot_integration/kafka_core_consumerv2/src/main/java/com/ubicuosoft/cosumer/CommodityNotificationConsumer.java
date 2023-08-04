package com.ubicuosoft.cosumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubicuosoft.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class CommodityNotificationConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-commodity", groupId = "cg-notification")
    public void listener(String message) throws JsonProcessingException {
        var commodity=objectMapper.readValue(message, Commodity.class);
        log.info("Consumer ---> cg-notification");
        log.info("message notification:{}",message);
    }
}
