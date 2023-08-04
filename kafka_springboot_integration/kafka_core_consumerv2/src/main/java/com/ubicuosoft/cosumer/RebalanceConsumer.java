package com.ubicuosoft.cosumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class RebalanceConsumer {
    @KafkaListener(topics = "t-rebalance", concurrency = "3")
    public void listener(ConsumerRecord<String, String> consumerRecord)
    {
        log.info("Consumer--->");
        log.info("Patition:{}, Offset:{}, Message:{}", consumerRecord.partition(), consumerRecord.offset(),consumerRecord.value());
    }
}
