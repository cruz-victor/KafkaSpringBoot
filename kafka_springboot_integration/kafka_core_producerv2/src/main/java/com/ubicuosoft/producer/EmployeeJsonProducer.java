package com.ubicuosoft.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubicuosoft.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeJsonProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(Employee employee) throws JsonProcessingException {
        var json=objectMapper.writeValueAsString(employee);
        kafkaTemplate.send("t-employee", json);
        log.info("Producer");
        log.info("Json: {}",json);
    }
}
