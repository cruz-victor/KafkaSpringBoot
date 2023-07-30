package com.ubicuosoft.cosumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
@Slf4j
public class KafkaKeyConsumer {

    //@KafkaListener(topics = "t-multi-partitions", concurrency = "1")
    @KafkaListener(topics = "t-multi-partitions")
    public void listener(ConsumerRecord<String, String> message) throws InterruptedException {
        //log.info("Consumer--->");
        log.info("Key: {}, Partition: {}, Message: {}", message.key(), message.partition(), message.value());
        //TimeUnit.SECONDS.sleep(1);
    }
}
