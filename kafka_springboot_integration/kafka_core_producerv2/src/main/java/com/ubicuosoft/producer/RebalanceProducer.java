package com.ubicuosoft.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

//@Service
@Slf4j
public class RebalanceProducer {
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    private AtomicInteger counter=new AtomicInteger();

    @Scheduled(fixedRate = 1000)
    public void send(){
        kafkaTemplate.send("t-rebalance", "Counter "+counter.incrementAndGet());
        log.info("Producer --->");
        log.info("t-rebalance value :{}",counter.get());
    }
}

