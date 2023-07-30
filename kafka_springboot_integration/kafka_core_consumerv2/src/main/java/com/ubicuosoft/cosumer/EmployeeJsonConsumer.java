package com.ubicuosoft.cosumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubicuosoft.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeJsonConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-employee")
    public void listener(String message) throws JsonProcessingException {
        Employee vic=objectMapper.readValue(message, Employee.class);
        log.info("Consumer--->");
        log.info("object: {}",message);
        log.info("Json object: {}",vic);
    }
}
