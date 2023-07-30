package com.ubicuosoft;

import com.ubicuosoft.entity.Employee;
import com.ubicuosoft.producer.EmployeeJsonProducer;
import com.ubicuosoft.producer.HelloKafkaProducer;
import com.ubicuosoft.producer.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {

//    @Autowired
//    HelloKafkaProducer helloKafkaProducer;

//    @Autowired
//    KafkaKeyProducer kafkaKeyProducer;

    @Autowired
    EmployeeJsonProducer employeeJsonProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaCoreProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //helloKafkaProducer.send("Victor "+ ThreadLocalRandom.current().nextInt());

//        for (int i = 0; i < 10000; i++) {
//            //var key= "key-" + (i%4);
//            var key="key-"+ ThreadLocalRandom.current().nextInt(0,3+1);
//            var message="value "+i+" with key "+key;
//            kafkaKeyProducer.send(key, message);
//        }

        Employee vic;
        for (int i = 0; i < 5; i++) {
            vic=new Employee("E"+i,"Employee"+i, LocalDate.now());
            employeeJsonProducer.send(vic);
        }

    }
}
