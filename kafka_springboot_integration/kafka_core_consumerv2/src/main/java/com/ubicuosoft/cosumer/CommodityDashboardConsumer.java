package com.ubicuosoft.cosumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubicuosoft.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//@Service
@Slf4j
public class CommodityDashboardConsumer {

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = "t-commodity", groupId = "cg-dashboard")
    public void listener(String message) throws JsonProcessingException, InterruptedException {
        var randomDelayMillis= ThreadLocalRandom.current().nextLong(2000,5000);
        TimeUnit.MICROSECONDS.sleep(randomDelayMillis);

        var commodity= objectMapper.readValue(message, Commodity.class);
        log.info("Consumer Dashboard--->{}",randomDelayMillis);
        log.info("Message dashbaoard:{}",message);
    }
}
