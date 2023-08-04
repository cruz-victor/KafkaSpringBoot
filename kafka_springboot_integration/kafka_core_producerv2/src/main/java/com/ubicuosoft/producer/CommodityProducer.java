package com.ubicuosoft.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubicuosoft.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class CommodityProducer {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;

    public void send(Commodity commodity) throws JsonProcessingException {
        var json=objectMapper.writeValueAsString(commodity);
        KafkaTemplate.send("t-commodity",commodity.getName(), json);
        log.info("Producer--->");
        log.info("json {}",json);
    }
}
